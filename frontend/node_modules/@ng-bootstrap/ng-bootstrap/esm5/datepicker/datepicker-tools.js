/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import { NgbDate } from './ngb-date';
import { isDefined } from '../util/util';
/**
 * @param {?} prev
 * @param {?} next
 * @return {?}
 */
export function isChangedDate(prev, next) {
    return !dateComparator(prev, next);
}
/**
 * @param {?} prev
 * @param {?} next
 * @return {?}
 */
export function dateComparator(prev, next) {
    return (!prev && !next) || (!!prev && !!next && prev.equals(next));
}
/**
 * @param {?} minDate
 * @param {?} maxDate
 * @return {?}
 */
export function checkMinBeforeMax(minDate, maxDate) {
    if (maxDate && minDate && maxDate.before(minDate)) {
        throw new Error("'maxDate' " + maxDate + " should be greater than 'minDate' " + minDate);
    }
}
/**
 * @param {?} date
 * @param {?} minDate
 * @param {?} maxDate
 * @return {?}
 */
export function checkDateInRange(date, minDate, maxDate) {
    if (date && minDate && date.before(minDate)) {
        return minDate;
    }
    if (date && maxDate && date.after(maxDate)) {
        return maxDate;
    }
    return date;
}
/**
 * @param {?} date
 * @param {?} state
 * @return {?}
 */
export function isDateSelectable(date, state) {
    var minDate = state.minDate, maxDate = state.maxDate, disabled = state.disabled, markDisabled = state.markDisabled;
    // clang-format off
    return !(!isDefined(date) ||
        disabled ||
        (markDisabled && markDisabled(date, { year: date.year, month: date.month })) ||
        (minDate && date.before(minDate)) ||
        (maxDate && date.after(maxDate)));
    // clang-format on
}
/**
 * @param {?} calendar
 * @param {?} date
 * @param {?} minDate
 * @param {?} maxDate
 * @return {?}
 */
export function generateSelectBoxMonths(calendar, date, minDate, maxDate) {
    if (!date) {
        return [];
    }
    /** @type {?} */
    var months = calendar.getMonths(date.year);
    if (minDate && date.year === minDate.year) {
        /** @type {?} */
        var index = months.findIndex(function (month) { return month === minDate.month; });
        months = months.slice(index);
    }
    if (maxDate && date.year === maxDate.year) {
        /** @type {?} */
        var index = months.findIndex(function (month) { return month === maxDate.month; });
        months = months.slice(0, index + 1);
    }
    return months;
}
/**
 * @param {?} date
 * @param {?} minDate
 * @param {?} maxDate
 * @return {?}
 */
export function generateSelectBoxYears(date, minDate, maxDate) {
    if (!date) {
        return [];
    }
    /** @type {?} */
    var start = minDate && minDate.year || date.year - 10;
    /** @type {?} */
    var end = maxDate && maxDate.year || date.year + 10;
    return Array.from({ length: end - start + 1 }, function (e, i) { return start + i; });
}
/**
 * @param {?} calendar
 * @param {?} date
 * @param {?} maxDate
 * @return {?}
 */
export function nextMonthDisabled(calendar, date, maxDate) {
    return maxDate && calendar.getNext(date, 'm').after(maxDate);
}
/**
 * @param {?} calendar
 * @param {?} date
 * @param {?} minDate
 * @return {?}
 */
export function prevMonthDisabled(calendar, date, minDate) {
    /** @type {?} */
    var prevDate = calendar.getPrev(date, 'm');
    return minDate && (prevDate.year === minDate.year && prevDate.month < minDate.month ||
        prevDate.year < minDate.year && minDate.month === 1);
}
/**
 * @param {?} calendar
 * @param {?} date
 * @param {?} state
 * @param {?} i18n
 * @param {?} force
 * @return {?}
 */
export function buildMonths(calendar, date, state, i18n, force) {
    var displayMonths = state.displayMonths, months = state.months;
    // move old months to a temporary array
    /** @type {?} */
    var monthsToReuse = months.splice(0, months.length);
    // generate new first dates, nullify or reuse months
    /** @type {?} */
    var firstDates = Array.from({ length: displayMonths }, function (_, i) {
        /** @type {?} */
        var firstDate = calendar.getNext(date, 'm', i);
        months[i] = null;
        if (!force) {
            /** @type {?} */
            var reusedIndex = monthsToReuse.findIndex(function (month) { return month.firstDate.equals(firstDate); });
            // move reused month back to months
            if (reusedIndex !== -1) {
                months[i] = monthsToReuse.splice(reusedIndex, 1)[0];
            }
        }
        return firstDate;
    });
    // rebuild nullified months
    firstDates.forEach(function (firstDate, i) {
        if (months[i] === null) {
            months[i] = buildMonth(calendar, firstDate, state, i18n, monthsToReuse.shift() || (/** @type {?} */ ({})));
        }
    });
    return months;
}
/**
 * @param {?} calendar
 * @param {?} date
 * @param {?} state
 * @param {?} i18n
 * @param {?=} month
 * @return {?}
 */
export function buildMonth(calendar, date, state, i18n, month) {
    if (month === void 0) { month = (/** @type {?} */ ({})); }
    var dayTemplateData = state.dayTemplateData, minDate = state.minDate, maxDate = state.maxDate, firstDayOfWeek = state.firstDayOfWeek, markDisabled = state.markDisabled, outsideDays = state.outsideDays;
    month.firstDate = null;
    month.lastDate = null;
    month.number = date.month;
    month.year = date.year;
    month.weeks = month.weeks || [];
    month.weekdays = month.weekdays || [];
    date = getFirstViewDate(calendar, date, firstDayOfWeek);
    // month has weeks
    for (var week = 0; week < calendar.getWeeksPerMonth(); week++) {
        /** @type {?} */
        var weekObject = month.weeks[week];
        if (!weekObject) {
            weekObject = month.weeks[week] = { number: 0, days: [], collapsed: true };
        }
        /** @type {?} */
        var days = weekObject.days;
        // week has days
        for (var day = 0; day < calendar.getDaysPerWeek(); day++) {
            if (week === 0) {
                month.weekdays[day] = calendar.getWeekday(date);
            }
            /** @type {?} */
            var newDate = new NgbDate(date.year, date.month, date.day);
            /** @type {?} */
            var nextDate = calendar.getNext(newDate);
            /** @type {?} */
            var ariaLabel = i18n.getDayAriaLabel(newDate);
            // marking date as disabled
            /** @type {?} */
            var disabled = !!((minDate && newDate.before(minDate)) || (maxDate && newDate.after(maxDate)));
            if (!disabled && markDisabled) {
                disabled = markDisabled(newDate, { month: month.number, year: month.year });
            }
            // adding user-provided data to the context
            /** @type {?} */
            var contextUserData = dayTemplateData ? dayTemplateData(newDate, { month: month.number, year: month.year }) : undefined;
            // saving first date of the month
            if (month.firstDate === null && newDate.month === month.number) {
                month.firstDate = newDate;
            }
            // saving last date of the month
            if (newDate.month === month.number && nextDate.month !== month.number) {
                month.lastDate = newDate;
            }
            /** @type {?} */
            var dayObject = days[day];
            if (!dayObject) {
                dayObject = days[day] = (/** @type {?} */ ({}));
            }
            dayObject.date = newDate;
            dayObject.context = Object.assign(dayObject.context || {}, {
                $implicit: newDate,
                date: newDate,
                data: contextUserData,
                currentMonth: month.number, disabled: disabled,
                focused: false,
                selected: false
            });
            dayObject.tabindex = -1;
            dayObject.ariaLabel = ariaLabel;
            dayObject.hidden = false;
            date = nextDate;
        }
        weekObject.number = calendar.getWeekNumber(days.map(function (day) { return day.date; }), firstDayOfWeek);
        // marking week as collapsed
        weekObject.collapsed = outsideDays === 'collapsed' && days[0].date.month !== month.number &&
            days[days.length - 1].date.month !== month.number;
    }
    return month;
}
/**
 * @param {?} calendar
 * @param {?} date
 * @param {?} firstDayOfWeek
 * @return {?}
 */
export function getFirstViewDate(calendar, date, firstDayOfWeek) {
    /** @type {?} */
    var daysPerWeek = calendar.getDaysPerWeek();
    /** @type {?} */
    var firstMonthDate = new NgbDate(date.year, date.month, 1);
    /** @type {?} */
    var dayOfWeek = calendar.getWeekday(firstMonthDate) % daysPerWeek;
    return calendar.getPrev(firstMonthDate, 'd', (daysPerWeek + dayOfWeek - firstDayOfWeek) % daysPerWeek);
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiZGF0ZXBpY2tlci10b29scy5qcyIsInNvdXJjZVJvb3QiOiJuZzovL0BuZy1ib290c3RyYXAvbmctYm9vdHN0cmFwLyIsInNvdXJjZXMiOlsiZGF0ZXBpY2tlci9kYXRlcGlja2VyLXRvb2xzLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7QUFBQSxPQUFPLEVBQUMsT0FBTyxFQUFDLE1BQU0sWUFBWSxDQUFDO0FBR25DLE9BQU8sRUFBQyxTQUFTLEVBQUMsTUFBTSxjQUFjLENBQUM7Ozs7OztBQUd2QyxNQUFNLFVBQVUsYUFBYSxDQUFDLElBQWEsRUFBRSxJQUFhO0lBQ3hELE9BQU8sQ0FBQyxjQUFjLENBQUMsSUFBSSxFQUFFLElBQUksQ0FBQyxDQUFDO0FBQ3JDLENBQUM7Ozs7OztBQUVELE1BQU0sVUFBVSxjQUFjLENBQUMsSUFBYSxFQUFFLElBQWE7SUFDekQsT0FBTyxDQUFDLENBQUMsSUFBSSxJQUFJLENBQUMsSUFBSSxDQUFDLElBQUksQ0FBQyxDQUFDLENBQUMsSUFBSSxJQUFJLENBQUMsQ0FBQyxJQUFJLElBQUksSUFBSSxDQUFDLE1BQU0sQ0FBQyxJQUFJLENBQUMsQ0FBQyxDQUFDO0FBQ3JFLENBQUM7Ozs7OztBQUVELE1BQU0sVUFBVSxpQkFBaUIsQ0FBQyxPQUFnQixFQUFFLE9BQWdCO0lBQ2xFLElBQUksT0FBTyxJQUFJLE9BQU8sSUFBSSxPQUFPLENBQUMsTUFBTSxDQUFDLE9BQU8sQ0FBQyxFQUFFO1FBQ2pELE1BQU0sSUFBSSxLQUFLLENBQUMsZUFBYSxPQUFPLDBDQUFxQyxPQUFTLENBQUMsQ0FBQztLQUNyRjtBQUNILENBQUM7Ozs7Ozs7QUFFRCxNQUFNLFVBQVUsZ0JBQWdCLENBQUMsSUFBYSxFQUFFLE9BQWdCLEVBQUUsT0FBZ0I7SUFDaEYsSUFBSSxJQUFJLElBQUksT0FBTyxJQUFJLElBQUksQ0FBQyxNQUFNLENBQUMsT0FBTyxDQUFDLEVBQUU7UUFDM0MsT0FBTyxPQUFPLENBQUM7S0FDaEI7SUFDRCxJQUFJLElBQUks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QUFXLEdBQUcsU0FBUyxHQUFHLGNBQWMsQ0FBQyxHQUFHLFdBQVcsQ0FBQyxDQUFDO0FBQ3pHLENBQUMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge05nYkRhdGV9IGZyb20gJy4vbmdiLWRhdGUnO1xuaW1wb3J0IHtEYXRlcGlja2VyVmlld01vZGVsLCBEYXlWaWV3TW9kZWwsIE1vbnRoVmlld01vZGVsfSBmcm9tICcuL2RhdGVwaWNrZXItdmlldy1tb2RlbCc7XG5pbXBvcnQge05nYkNhbGVuZGFyfSBmcm9tICcuL25nYi1jYWxlbmRhcic7XG5pbXBvcnQge2lzRGVmaW5lZH0gZnJvbSAnLi4vdXRpbC91dGlsJztcbmltcG9ydCB7TmdiRGF0ZXBpY2tlckkxOG59IGZyb20gJy4vZGF0ZXBpY2tlci1pMThuJztcblxuZXhwb3J0IGZ1bmN0aW9uIGlzQ2hhbmdlZERhdGUocHJldjogTmdiRGF0ZSwgbmV4dDogTmdiRGF0ZSkge1xuICByZXR1cm4gIWRhdGVDb21wYXJhdG9yKHByZXYsIG5leHQpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gZGF0ZUNvbXBhcmF0b3IocHJldjogTmdiRGF0ZSwgbmV4dDogTmdiRGF0ZSkge1xuICByZXR1cm4gKCFwcmV2ICYmICFuZXh0KSB8fCAoISFwcmV2ICYmICEhbmV4dCAmJiBwcmV2LmVxdWFscyhuZXh0KSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBjaGVja01pbkJlZm9yZU1heChtaW5EYXRlOiBOZ2JEYXRlLCBtYXhEYXRlOiBOZ2JEYXRlKSB7XG4gIGlmIChtYXhEYXRlICYmIG1pbkRhdGUgJiYgbWF4RGF0ZS5iZWZvcmUobWluRGF0ZSkpIHtcbiAgICB0aHJvdyBuZXcgRXJyb3IoYCdtYXhEYXRlJyAke21heERhdGV9IHNob3VsZCBiZSBncmVhdGVyIHRoYW4gJ21pbkRhdGUnICR7bWluRGF0ZX1gKTtcbiAgfVxufVxuXG5leHBvcnQgZnVuY3Rpb24gY2hlY2tEYXRlSW5SYW5nZShkYXRlOiBOZ2JEYXRlLCBtaW5EYXRlOiBOZ2JEYXRlLCBtYXhEYXRlOiBOZ2JEYXRlKTogTmdiRGF0ZSB7XG4gIGlmIChkYXRlICYmIG1pbkRhdGUgJiYgZGF0ZS5iZWZvcmUobWluRGF0ZSkpIHtcbiAgICByZXR1cm4gbWluRGF0ZTtcbiAgfVxuICBpZiAoZGF0ZSAmJiBtYXhEYXRlICYmIGRhdGUuYWZ0ZXIobWF4RGF0ZSkpIHtcbiAgICByZXR1cm4gbWF4RGF0ZTtcbiAgfVxuXG4gIHJldHVybiBkYXRlO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gaXNEYXRlU2VsZWN0YWJsZShkYXRlOiBOZ2JEYXRlLCBzdGF0ZTogRGF0ZXBpY2tlclZpZXdNb2RlbCkge1xuICBjb25zdCB7bWluRGF0ZSwgbWF4RGF0ZSwgZGlzYWJsZWQsIG1hcmtEaXNhYmxlZH0gPSBzdGF0ZTtcbiAgLy8gY2xhbmctZm9ybWF0IG9mZlxuICByZXR1cm4gIShcbiAgICAhaXNEZWZpbmVkKGRhdGUpIHx8XG4gICAgZGlzYWJsZWQgfHxcbiAgICAobWFya0Rpc2FibGVkICYmIG1hcmtEaXNhYmxlZChkYXRlLCB7eWVhcjogZGF0ZS55ZWFyLCBtb250aDogZGF0ZS5tb250aH0pKSB8fFxuICAgIChtaW5EYXRlICYmIGRhdGUuYmVmb3JlKG1pbkRhdGUpKSB8fFxuICAgIChtYXhEYXRlICYmIGRhdGUuYWZ0ZXIobWF4RGF0ZSkpXG4gICk7XG4gIC8vIGNsYW5nLWZvcm1hdCBvblxufVxuXG5leHBvcnQgZnVuY3Rpb24gZ2VuZXJhdGVTZWxlY3RCb3hNb250aHMoY2FsZW5kYXI6IE5nYkNhbGVuZGFyLCBkYXRlOiBOZ2JEYXRlLCBtaW5EYXRlOiBOZ2JEYXRlLCBtYXhEYXRlOiBOZ2JEYXRlKSB7XG4gIGlmICghZGF0ZSkge1xuICAgIHJldHVybiBbXTtcbiAgfVxuXG4gIGxldCBtb250aHMgPSBjYWxlbmRhci5nZXRNb250aHMoZGF0ZS55ZWFyKTtcblxuICBpZiAobWluRGF0ZSAmJiBkYXRlLnllYXIgPT09IG1pbkRhdGUueWVhcikge1xuICAgIGNvbnN0IGluZGV4ID0gbW9udGhzLmZpbmRJbmRleChtb250aCA9PiBtb250aCA9PT0gbWluRGF0ZS5tb250aCk7XG4gICAgbW9udGhzID0gbW9udGhzLnNsaWNlKGluZGV4KTtcbiAgfVxuXG4gIGlmIChtYXhEYXRlICYmIGRhdGUueWVhciA9PT0gbWF4RGF0ZS55ZWFyKSB7XG4gICAgY29uc3QgaW5kZXggPSBtb250aHMuZmluZEluZGV4KG1vbnRoID0+IG1vbnRoID09PSBtYXhEYXRlLm1vbnRoKTtcbiAgICBtb250aHMgPSBtb250aHMuc2xpY2UoMCwgaW5kZXggKyAxKTtcbiAgfVxuXG4gIHJldHVybiBtb250aHM7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBnZW5lcmF0ZVNlbGVjdEJveFllYXJzKGRhdGU6IE5nYkRhdGUsIG1pbkRhdGU6IE5nYkRhdGUsIG1heERhdGU6IE5nYkRhdGUpIHtcbiAgaWYgKCFkYXRlKSB7XG4gICAgcmV0dXJuIFtdO1xuICB9XG5cbiAgY29uc3Qgc3RhcnQgPSBtaW5EYXRlICYmIG1pbkRhdGUueWVhciB8fCBkYXRlLnllYXIgLSAxMDtcbiAgY29uc3QgZW5kID0gbWF4RGF0ZSAmJiBtYXhEYXRlLnllYXIgfHwgZGF0ZS55ZWFyICsgMTA7XG5cbiAgcmV0dXJuIEFycmF5LmZyb20oe2xlbmd0aDogZW5kIC0gc3RhcnQgKyAxfSwgKGUsIGkpID0+IHN0YXJ0ICsgaSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBuZXh0TW9udGhEaXNhYmxlZChjYWxlbmRhcjogTmdiQ2FsZW5kYXIsIGRhdGU6IE5nYkRhdGUsIG1heERhdGU6IE5nYkRhdGUpIHtcbiAgcmV0dXJuIG1heERhdGUgJiYgY2FsZW5kYXIuZ2V0TmV4dChkYXRlLCAnbScpLmFmdGVyKG1heERhdGUpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gcHJldk1vbnRoRGlzYWJsZWQoY2FsZW5kYXI6IE5nYkNhbGVuZGFyLCBkYXRlOiBOZ2JEYXRlLCBtaW5EYXRlOiBOZ2JEYXRlKSB7XG4gIGNvbnN0IHByZXZEYXRlID0gY2FsZW5kYXIuZ2V0UHJldihkYXRlLCAnbScpO1xuICByZXR1cm4gbWluRGF0ZSAmJiAocHJldkRhdGUueWVhciA9PT0gbWluRGF0ZS55ZWFyICYmIHByZXZEYXRlLm1vbnRoIDwgbWluRGF0ZS5tb250aCB8fFxuICAgICAgICAgICAgICAgICAgICAgcHJldkRhdGUueWVhciA8IG1pbkRhdGUueWVhciAmJiBtaW5EYXRlLm1vbnRoID09PSAxKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGJ1aWxkTW9udGhzKFxuICAgIGNhbGVuZGFyOiBOZ2JDYWxlbmRhciwgZGF0ZTogTmdiRGF0ZSwgc3RhdGU6IERhdGVwaWNrZXJWaWV3TW9kZWwsIGkxOG46IE5nYkRhdGVwaWNrZXJJMThuLFxuICAgIGZvcmNlOiBib29sZWFuKTogTW9udGhWaWV3TW9kZWxbXSB7XG4gIGNvbnN0IHtkaXNwbGF5TW9udGhzLCBtb250aHN9ID0gc3RhdGU7XG4gIC8vIG1vdmUgb2xkIG1vbnRocyB0byBhIHRlbXBvcmFyeSBhcnJheVxuICBjb25zdCBtb250aHNUb1JldXNlID0gbW9udGhzLnNwbGljZSgwLCBtb250aHMubGVuZ3RoKTtcblxuICAvLyBnZW5lcmF0ZSBuZXcgZmlyc3QgZGF0ZXMsIG51bGxpZnkgb3IgcmV1c2UgbW9udGhzXG4gIGNvbnN0IGZpcnN0RGF0ZXMgPSBBcnJheS5mcm9tKHtsZW5ndGg6IGRpc3BsYXlNb250aHN9LCAoXywgaSkgPT4ge1xuICAgIGNvbnN0IGZpcnN0RGF0ZSA9IGNhbGVuZGFyLmdldE5leHQoZGF0ZSwgJ20nLCBpKTtcbiAgICBtb250aHNbaV0gPSBudWxsO1xuXG4gICAgaWYgKCFmb3JjZSkge1xuICAgICAgY29uc3QgcmV1c2VkSW5kZXggPSBtb250aHNUb1JldXNlLmZpbmRJbmRleChtb250aCA9PiBtb250aC5maXJzdERhdGUuZXF1YWxzKGZpcnN0RGF0ZSkpO1xuICAgICAgLy8gbW92ZSByZXVzZWQgbW9udGggYmFjayB0byBtb250aHNcbiAgICAgIGlmIChyZXVzZWRJbmRleCAhPT0gLTEpIHtcbiAgICAgICAgbW9udGhzW2ldID0gbW9udGhzVG9SZXVzZS5zcGxpY2UocmV1c2VkSW5kZXgsIDEpWzBdO1xuICAgICAgfVxuICAgIH1cblxuICAgIHJldHVybiBmaXJzdERhdGU7XG4gIH0pO1xuXG4gIC8vIHJlYnVpbGQgbnVsbGlmaWVkIG1vbnRoc1xuICBmaXJzdERhdGVzLmZvckVhY2goKGZpcnN0RGF0ZSwgaSkgPT4ge1xuICAgIGlmIChtb250aHNbaV0gPT09IG51bGwpIHtcbiAgICAgIG1vbnRoc1tpXSA9IGJ1aWxkTW9udGgoY2FsZW5kYXIsIGZpcnN0RGF0ZSwgc3RhdGUsIGkxOG4sIG1vbnRoc1RvUmV1c2Uuc2hpZnQoKSB8fCB7fSBhcyBNb250aFZpZXdNb2RlbCk7XG4gICAgfVxuICB9KTtcblxuICByZXR1cm4gbW9udGhzO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gYnVpbGRNb250aChcbiAgICBjYWxlbmRhcjogTmdiQ2FsZW5kYXIsIGRhdGU6IE5nYkRhdGUsIHN0YXRlOiBEYXRlcGlja2VyVmlld01vZGVsLCBpMThuOiBOZ2JEYXRlcGlja2VySTE4bixcbiAgICBtb250aDogTW9udGhWaWV3TW9kZWwgPSB7fSBhcyBNb250aFZpZXdNb2RlbCk6IE1vbnRoVmlld01vZGVsIHtcbiAgY29uc3Qge2RheVRlbXBsYXRlRGF0YSwgbWluRGF0ZSwgbWF4RGF0ZSwgZmlyc3REYXlPZldlZWssIG1hcmtEaXNhYmxlZCwgb3V0c2lkZURheXN9ID0gc3RhdGU7XG5cbiAgbW9udGguZmlyc3REYXRlID0gbnVsbDtcbiAgbW9udGgubGFzdERhdGUgPSBudWxsO1xuICBtb250aC5udW1iZXIgPSBkYXRlLm1vbnRoO1xuICBtb250aC55ZWFyID0gZGF0ZS55ZWFyO1xuICBtb250aC53ZWVrcyA9IG1vbnRoLndlZWtzIHx8IFtdO1xuICBtb250aC53ZWVrZGF5cyA9IG1vbnRoLndlZWtkYXlzIHx8IFtdO1xuXG4gIGRhdGUgPSBnZXRGaXJzdFZpZXdEYXRlKGNhbGVuZGFyLCBkYXRlLCBmaXJzdERheU9mV2Vlayk7XG5cbiAgLy8gbW9udGggaGFzIHdlZWtzXG4gIGZvciAobGV0IHdlZWsgPSAwOyB3ZWVrIDwgY2FsZW5kYXIuZ2V0V2Vla3NQZXJNb250aCgpOyB3ZWVrKyspIHtcbiAgICBsZXQgd2Vla09iamVjdCA9IG1vbnRoLndlZWtzW3dlZWtdO1xuICAgIGlmICghd2Vla09iamVjdCkge1xuICAgICAgd2Vla09iamVjdCA9IG1vbnRoLndlZWtzW3dlZWtdID0ge251bWJlcjogMCwgZGF5czogW10sIGNvbGxhcHNlZDogdHJ1ZX07XG4gICAgfVxuICAgIGNvbnN0IGRheXMgPSB3ZWVrT2JqZWN0LmRheXM7XG5cbiAgICAvLyB3ZWVrIGhhcyBkYXlzXG4gICAgZm9yIChsZXQgZGF5ID0gMDsgZGF5IDwgY2FsZW5kYXIuZ2V0RGF5c1BlcldlZWsoKTsgZGF5KyspIHtcbiAgICAgIGlmICh3ZWVrID09PSAwKSB7XG4gICAgICAgIG1vbnRoLndlZWtkYXlzW2RheV0gPSBjYWxlbmRhci5nZXRXZWVrZGF5KGRhdGUpO1xuICAgICAgfVxuXG4gICAgICBjb25zdCBuZXdEYXRlID0gbmV3IE5nYkRhdGUoZGF0ZS55ZWFyLCBkYXRlLm1vbnRoLCBkYXRlLmRheSk7XG4gICAgICBjb25zdCBuZXh0RGF0ZSA9IGNhbGVuZGFyLmdldE5leHQobmV3RGF0ZSk7XG5cbiAgICAgIGNvbnN0IGFyaWFMYWJlbCA9IGkxOG4uZ2V0RGF5QXJpYUxhYmVsKG5ld0RhdGUpO1xuXG4gICAgICAvLyBtYXJraW5nIGRhdGUgYXMgZGlzYWJsZWRcbiAgICAgIGxldCBkaXNhYmxlZCA9ICEhKChtaW5EYXRlICYmIG5ld0RhdGUuYmVmb3JlKG1pbkRhdGUpKSB8fCAobWF4RGF0ZSAmJiBuZXdEYXRlLmFmdGVyKG1heERhdGUpKSk7XG4gICAgICBpZiAoIWRpc2FibGVkICYmIG1hcmtEaXNhYmxlZCkge1xuICAgICAgICBkaXNhYmxlZCA9IG1hcmtEaXNhYmxlZChuZXdEYXRlLCB7bW9udGg6IG1vbnRoLm51bWJlciwgeWVhcjogbW9udGgueWVhcn0pO1xuICAgICAgfVxuXG4gICAgICAvLyBhZGRpbmcgdXNlci1wcm92aWRlZCBkYXRhIHRvIHRoZSBjb250ZXh0XG4gICAgICBsZXQgY29udGV4dFVzZXJEYXRhID1cbiAgICAgICAgICBkYXlUZW1wbGF0ZURhdGEgPyBkYXlUZW1wbGF0ZURhdGEobmV3RGF0ZSwge21vbnRoOiBtb250aC5udW1iZXIsIHllYXI6IG1vbnRoLnllYXJ9KSA6IHVuZGVmaW5lZDtcblxuICAgICAgLy8gc2F2aW5nIGZpcnN0IGRhdGUgb2YgdGhlIG1vbnRoXG4gICAgICBpZiAobW9udGguZmlyc3REYXRlID09PSBudWxsICYmIG5ld0RhdGUubW9udGggPT09IG1vbnRoLm51bWJlcikge1xuICAgICAgICBtb250aC5maXJzdERhdGUgPSBuZXdEYXRlO1xuICAgICAgfVxuXG4gICAgICAvLyBzYXZpbmcgbGFzdCBkYXRlIG9mIHRoZSBtb250aFxuICAgICAgaWYgKG5ld0RhdGUubW9udGggPT09IG1vbnRoLm51bWJlciAmJiBuZXh0RGF0ZS5tb250aCAhPT0gbW9udGgubnVtYmVyKSB7XG4gICAgICAgIG1vbnRoLmxhc3REYXRlID0gbmV3RGF0ZTtcbiAgICAgIH1cblxuICAgICAgbGV0IGRheU9iamVjdCA9IGRheXNbZGF5XTtcbiAgICAgIGlmICghZGF5T2JqZWN0KSB7XG4gICAgICAgIGRheU9iamVjdCA9IGRheXNbZGF5XSA9IHt9IGFzIERheVZpZXdNb2RlbDtcbiAgICAgIH1cbiAgICAgIGRheU9iamVjdC5kYXRlID0gbmV3RGF0ZTtcbiAgICAgIGRheU9iamVjdC5jb250ZXh0ID0gT2JqZWN0LmFzc2lnbihkYXlPYmplY3QuY29udGV4dCB8fCB7fSwge1xuICAgICAgICAkaW1wbGljaXQ6IG5ld0RhdGUsXG4gICAgICAgIGRhdGU6IG5ld0RhdGUsXG4gICAgICAgIGRhdGE6IGNvbnRleHRVc2VyRGF0YSxcbiAgICAgICAgY3VycmVudE1vbnRoOiBtb250aC5udW1iZXIsIGRpc2FibGVkLFxuICAgICAgICBmb2N1c2VkOiBmYWxzZSxcbiAgICAgICAgc2VsZWN0ZWQ6IGZhbHNlXG4gICAgICB9KTtcbiAgICAgIGRheU9iamVjdC50YWJpbmRleCA9IC0xO1xuICAgICAgZGF5T2JqZWN0LmFyaWFMYWJlbCA9IGFyaWFMYWJlbDtcbiAgICAgIGRheU9iamVjdC5oaWRkZW4gPSBmYWxzZTtcblxuICAgICAgZGF0ZSA9IG5leHREYXRlO1xuICAgIH1cblxuICAgIHdlZWtPYmplY3QubnVtYmVyID0gY2FsZW5kYXIuZ2V0V2Vla051bWJlcihkYXlzLm1hcChkYXkgPT4gZGF5LmRhdGUpLCBmaXJzdERheU9mV2Vlayk7XG5cbiAgICAvLyBtYXJraW5nIHdlZWsgYXMgY29sbGFwc2VkXG4gICAgd2Vla09iamVjdC5jb2xsYXBzZWQgPSBvdXRzaWRlRGF5cyA9PT0gJ2NvbGxhcHNlZCcgJiYgZGF5c1swXS5kYXRlLm1vbnRoICE9PSBtb250aC5udW1iZXIgJiZcbiAgICAgICAgZGF5c1tkYXlzLmxlbmd0aCAtIDFdLmRhdGUubW9udGggIT09IG1vbnRoLm51bWJlcjtcbiAgfVxuXG4gIHJldHVybiBtb250aDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGdldEZpcnN0Vmlld0RhdGUoY2FsZW5kYXI6IE5nYkNhbGVuZGFyLCBkYXRlOiBOZ2JEYXRlLCBmaXJzdERheU9mV2VlazogbnVtYmVyKTogTmdiRGF0ZSB7XG4gIGNvbnN0IGRheXNQZXJXZWVrID0gY2FsZW5kYXIuZ2V0RGF5c1BlcldlZWsoKTtcbiAgY29uc3QgZmlyc3RNb250aERhdGUgPSBuZXcgTmdiRGF0ZShkYXRlLnllYXIsIGRhdGUubW9udGgsIDEpO1xuICBjb25zdCBkYXlPZldlZWsgPSBjYWxlbmRhci5nZXRXZWVrZGF5KGZpcnN0TW9udGhEYXRlKSAlIGRheXNQZXJXZWVrO1xuICByZXR1cm4gY2FsZW5kYXIuZ2V0UHJldihmaXJzdE1vbnRoRGF0ZSwgJ2QnLCAoZGF5c1BlcldlZWsgKyBkYXlPZldlZWsgLSBmaXJzdERheU9mV2VlaykgJSBkYXlzUGVyV2Vlayk7XG59XG4iXX0=