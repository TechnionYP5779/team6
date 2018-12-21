/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import { Component, forwardRef, Input } from '@angular/core';
import { NG_VALUE_ACCESSOR } from '@angular/forms';
import { isNumber, padNumber, toInteger } from '../util/util';
import { NgbTime } from './ngb-time';
import { NgbTimepickerConfig } from './timepicker-config';
import { NgbTimeAdapter } from './ngb-time-adapter';
/** @type {?} */
const NGB_TIMEPICKER_VALUE_ACCESSOR = {
    provide: NG_VALUE_ACCESSOR,
    useExisting: forwardRef(() => NgbTimepicker),
    multi: true
};
/**
 * A lightweight & configurable timepicker directive.
 */
export class NgbTimepicker {
    /**
     * @param {?} config
     * @param {?} _ngbTimeAdapter
     */
    constructor(config, _ngbTimeAdapter) {
        this._ngbTimeAdapter = _ngbTimeAdapter;
        this.onChange = (_) => { };
        this.onTouched = () => { };
        this.meridian = config.meridian;
        this.spinners = config.spinners;
        this.seconds = config.seconds;
        this.hourStep = config.hourStep;
        this.minuteStep = config.minuteStep;
        this.secondStep = config.secondStep;
        this.disabled = config.disabled;
        this.readonlyInputs = config.readonlyInputs;
        this.size = config.size;
    }
    /**
     * @param {?} value
     * @return {?}
     */
    writeValue(value) {
        /** @type {?} */
        const structValue = this._ngbTimeAdapter.fromModel(value);
        this.model = structValue ? new NgbTime(structValue.hour, structValue.minute, structValue.second) : new NgbTime();
        if (!this.seconds && (!structValue || !isNumber(structValue.second))) {
            this.model.second = 0;
        }
    }
    /**
     * @param {?} fn
     * @return {?}
     */
    registerOnChange(fn) { this.onChange = fn; }
    /**
     * @param {?} fn
     * @return {?}
     */
    registerOnTouched(fn) { this.onTouched = fn; }
    /**
     * @param {?} isDisabled
     * @return {?}
     */
    setDisabledState(isDisabled) { this.disabled = isDisabled; }
    /**
     * @param {?} step
     * @return {?}
     */
    changeHour(step) {
        this.model.changeHour(step);
        this.propagateModelChange();
    }
    /**
     * @param {?} step
     * @return {?}
     */
    changeMinute(step) {
        this.model.changeMinute(step);
        this.propagateModelChange();
    }
    /**
     * @param {?} step
     * @return {?}
     */
    changeSecond(step) {
        this.model.changeSecond(step);
        this.propagateModelChange();
    }
    /**
     * @param {?} newVal
     * @return {?}
     */
    updateHour(newVal) {
        /** @type {?} */
        const isPM = this.model.hour >= 12;
        /** @type {?} */
        const enteredHour = toInteger(newVal);
        if (this.meridian && (isPM && enteredHour < 12 || !isPM && enteredHour === 12)) {
            this.model.updateHour(enteredHour + 12);
        }
        else {
            this.model.updateHour(enteredHour);
        }
        this.propagateModelChange();
    }
    /**
     * @param {?} newVal
     * @return {?}
     */
    updateMinute(newVal) {
        this.model.updateMinute(toInteger(newVal));
        this.propagateModelChange();
    }
    /**
     * @param {?} newVal
     * @return {?}
     */
    updateSecond(newVal) {
        this.model.updateSecond(toInteger(newVal));
        this.propagateModelChange();
    }
    /**
     * @return {?}
     */
    toggleMeridian() {
        if (this.meridian) {
            this.changeHour(12);
        }
    }
    /**
     * @param {?} value
     * @return {?}
     */
    formatHour(value) {
        if (isNumber(value)) {
            if (this.meridian) {
                return padNumber(value % 12 === 0 ? 12 : value % 12);
            }
            else {
                return padNumber(value % 24);
            }
        }
        else {
            return padNumber(NaN);
        }
    }
    /**
     * @param {?} value
     * @return {?}
     */
    formatMinSec(value) { return padNumber(value); }
    /**
     * @return {?}
     */
    get isSmallSize() { return this.size === 'small'; }
    /**
     * @return {?}
     */
    get isLargeSize() { return this.size === 'large'; }
    /**
     * @param {?} changes
     * @return {?}
     */
    ngOnChanges(changes) {
        if (changes['seconds'] && !this.seconds && this.model && !isNumber(this.model.second)) {
            this.model.second = 0;
            this.propagateModelChange(false);
        }
    }
    /**
     * @param {?=} touched
     * @return {?}
     */
    propagateModelChange(touched = true) {
        if (touched) {
            this.onTouched();
        }
        if (this.model.isValid(this.seconds)) {
            this.onChange(this._ngbTimeAdapter.toModel({ hour: this.model.hour, minute: this.model.minute, second: this.model.second }));
        }
        else {
            this.onChange(this._ngbTimeAdapter.toModel(null));
        }
    }
}
NgbTimepicker.decorators = [
    { type: Component, args: [{
                selector: 'ngb-timepicker',
                template: `
    <fieldset [disabled]="disabled" [class.disabled]="disabled">
      <div class="ngb-tp">
        <div class="ngb-tp-input-container ngb-tp-hour">
          <button *ngIf="spinners" type="button" (click)="changeHour(hourStep)"
            class="btn btn-link" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize" [class.disabled]="disabled"
            [disabled]="disabled">
            <span class="chevron"></span>
            <span class="sr-only" i18n="@@ngb.timepicker.increment-hours">Increment hours</span>
          </button>
          <input type="text" class="form-control" [class.form-control-sm]="isSmallSize" [class.form-control-lg]="isLargeSize" maxlength="2"
            placeholder="HH" i18n-placeholder="@@ngb.timepicker.HH"
            [value]="formatHour(model?.hour)" (change)="updateHour($event.target.value)"
            [readonly]="readonlyInputs" [disabled]="disabled" aria-label="Hours" i18n-aria-label="@@ngb.timepicker.hours">
          <button *ngIf="spinners" type="button" (click)="changeHour(-hourStep)"
            class="btn btn-link" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize" [class.disabled]="disabled"
            [disabled]="disabled">
            <span class="chevron bottom"></span>
            <span class="sr-only" i18n="@@ngb.timepicker.decrement-hours">Decrement hours</span>
          </button>
        </div>
        <div class="ngb-tp-spacer">:</div>
        <div class="ngb-tp-input-container ngb-tp-minute">
          <button *ngIf="spinners" type="button" (click)="changeMinute(minuteStep)"
            class="btn btn-link" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize" [class.disabled]="disabled"
            [disabled]="disabled">
            <span class="chevron"></span>
            <span class="sr-only" i18n="@@ngb.timepicker.increment-minutes">Increment minutes</span>
          </button>
          <input type="text" class="form-control" [class.form-control-sm]="isSmallSize" [class.form-control-lg]="isLargeSize" maxlength="2"
            placeholder="MM" i18n-placeholder="@@ngb.timepicker.MM"
            [value]="formatMinSec(model?.minute)" (change)="updateMinute($event.target.value)"
            [readonly]="readonlyInputs" [disabled]="disabled" aria-label="Minutes" i18n-aria-label="@@ngb.timepicker.minutes">
          <button *ngIf="spinners" type="button" (click)="changeMinute(-minuteStep)"
            class="btn btn-link" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize"  [class.disabled]="disabled"
            [disabled]="disabled">
            <span class="chevron bottom"></span>
            <span class="sr-only"  i18n="@@ngb.timepicker.decrement-minutes">Decrement minutes</span>
          </button>
        </div>
        <div *ngIf="seconds" class="ngb-tp-spacer">:</div>
        <div *ngIf="seconds" class="ngb-tp-input-container ngb-tp-second">
          <button *ngIf="spinners" type="button" (click)="changeSecond(secondStep)"
            class="btn btn-link" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize" [class.disabled]="disabled"
            [disabled]="disabled">
            <span class="chevron"></span>
            <span class="sr-only" i18n="@@ngb.timepicker.increment-seconds">Increment seconds</span>
          </button>
          <input type="text" class="form-control" [class.form-control-sm]="isSmallSize" [class.form-control-lg]="isLargeSize" maxlength="2"
            placeholder="SS" i18n-placeholder="@@ngb.timepicker.SS"
            [value]="formatMinSec(model?.second)" (change)="updateSecond($event.target.value)"
            [readonly]="readonlyInputs" [disabled]="disabled" aria-label="Seconds" i18n-aria-label="@@ngb.timepicker.seconds">
          <button *ngIf="spinners" type="button" (click)="changeSecond(-secondStep)"
            class="btn btn-link" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize"  [class.disabled]="disabled"
            [disabled]="disabled">
            <span class="chevron bottom"></span>
            <span class="sr-only" i18n="@@ngb.timepicker.decrement-seconds">Decrement seconds</span>
          </button>
        </div>
        <div *ngIf="meridian" class="ngb-tp-spacer"></div>
        <div *ngIf="meridian" class="ngb-tp-meridian">
          <button type="button" class="btn btn-outline-primary" [class.btn-sm]="isSmallSize" [class.btn-lg]="isLargeSize"
            [disabled]="disabled" [class.disabled]="disabled"
                  (click)="toggleMeridian()">
            <ng-container *ngIf="model?.hour >= 12; else am" i18n="@@ngb.timepicker.PM">PM</ng-container>
            <ng-template #am i18n="@@ngb.timepicker.AM">AM</ng-template>
          </button>
        </div>
      </div>
    </fieldset>
  `,
                providers: [NGB_TIMEPICKER_VALUE_ACCESSOR],
                styles: [":host{font-size:1rem}.ngb-tp{display:-ms-flexbox;display:flex;-ms-flex-align:center;align-items:center}.ngb-tp-input-container{width:4em}.ngb-tp-hour,.ngb-tp-meridian,.ngb-tp-minute,.ngb-tp-second{display:-ms-flexbox;display:flex;-ms-flex-direction:column;flex-direction:column;-ms-flex-align:center;align-items:center;-ms-flex-pack:distribute;justify-content:space-around}.ngb-tp-spacer{width:1em;text-align:center}.chevron::before{border-style:solid;border-width:.29em .29em 0 0;content:'';display:inline-block;height:.69em;left:.05em;position:relative;top:.15em;-webkit-transform:rotate(-45deg);transform:rotate(-45deg);vertical-align:middle;width:.69em}.chevron.bottom:before{top:-.3em;-webkit-transform:rotate(135deg);transform:rotate(135deg)}input{text-align:center}"]
            }] }
];
/** @nocollapse */
NgbTimepicker.ctorParameters = () => [
    { type: NgbTimepickerConfig },
    { type: NgbTimeAdapter }
];
NgbTimepicker.propDecorators = {
    meridian: [{ type: Input }],
    spinners: [{ type: Input }],
    seconds: [{ type: Input }],
    hourStep: [{ type: Input }],
    minuteStep: [{ type: Input }],
    secondStep: [{ type: Input }],
    readonlyInputs: [{ type: Input }],
    size: [{ type: Input }]
};
if (false) {
    /** @type {?} */
    NgbTimepicker.prototype.disabled;
    /** @type {?} */
    NgbTimepicker.prototype.model;
    /**
     * Whether to display 12H or 24H mode.
     * @type {?}
     */
    NgbTimepicker.prototype.meridian;
    /**
     * Whether to display the spinners above and below the inputs.
     * @type {?}
     */
    NgbTimepicker.prototype.spinners;
    /**
     * Whether to display seconds input.
     * @type {?}
     */
    NgbTimepicker.prototype.seconds;
    /**
     * Number of hours to increase or decrease when using a button.
     * @type {?}
     */
    NgbTimepicker.prototype.hourStep;
    /**
     * Number of minutes to increase or decrease when using a button.
     * @type {?}
     */
    NgbTimepicker.prototype.minuteStep;
    /**
     * Number of seconds to increase or decrease when using a button.
     * @type {?}
     */
    NgbTimepicker.prototype.secondStep;
    /**
     * To make timepicker readonly
     * @type {?}
     */
    NgbTimepicker.prototype.readonlyInputs;
    /**
     * To set the size of the inputs and button
     * @type {?}
     */
    NgbTimepicker.prototype.size;
    /** @type {?} */
    NgbTimepicker.prototype.onChange;
    /** @type {?} */
    NgbTimepicker.prototype.onTouched;
    /** @type {?} */
    NgbTimepicker.prototype._ngbTimeAdapter;
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidGltZXBpY2tlci5qcyIsInNvdXJjZVJvb3QiOiJuZzovL0BuZy1ib290c3RyYXAvbmctYm9vdHN0cmFwLyIsInNvdXJjZXMiOlsidGltZXBpY2tlci90aW1lcGlja2VyLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7QUFBQSxPQUFPLEVBQUMsU0FBUyxFQUFFLFVBQVUsRUFBRSxLQUFLLEVBQTJCLE1BQU0sZUFBZSxDQUFDO0FBQ3JGLE9BQU8sRUFBdUIsaUJBQWlCLEVBQUMsTUFBTSxnQkFBZ0IsQ0FBQztBQUV2RSxPQUFPLEVBQUMsUUFBUSxFQUFFLFNBQVMsRUFBRSxTQUFTLEVBQUMsTUFBTSxjQUFjLENBQUM7QUFDNUQsT0FBTyxFQUFDLE9BQU8sRUFBQyxNQUFNLFlBQVksQ0FBQztBQUNuQyxPQUFPLEVBQUMsbUJBQW1CLEVBQUMsTUFBTSxxQkFBcUIsQ0FBQztBQUN4RCxPQUFPLEVBQUMsY0FBYyxFQUFDLE1BQU0sb0JBQW9CLENBQUM7O01BRTVDLDZCQUE2QixHQUFHO0lBQ3BDLE9BQU8sRUFBRSxpQkFBaUI7SUFDMUIsV0FBVyxFQUFFLFVBQVUsQ0FBQyxHQUFHLEVBQUUsQ0FBQyxhQUFhLENBQUM7SUFDNUMsS0FBSyxFQUFFLElBQUk7Q0FDWjs7OztBQWlGRCxNQUFNLE9BQU8sYUFBYTs7Ozs7SUE2Q3hCLFlBQVksTUFBMkIsRUFBVSxlQUFvQztRQUFwQyxvQkFBZSxHQUFmLGVBQWUsQ0FBcUI7UUFZckYsYUFBUSxHQUFHLENBQUMsQ0FBTSxFQUFFLEVBQUUsR0FBRSxDQUFDLENBQUM7UUFDMUIsY0FBUyxHQUFHLEdBQUcsRUFBRSxHQUFFLENBQUMsQ0FBQztRQVpuQixJQUFJLENBQUMsUUFBUSxHQUFHLE1BQU0sQ0FBQyxRQUFRLENBQUM7UUFDaEMsSUFBSSxDQUFDLFFBQVEsR0FBRyxNQUFNLENBQUMsUUFBUSxDQUFDO1FBQ2hDLElBQUksQ0FBQyxPQUFPLEdBQUcsTUFBTSxDQUFDLE9BQU8sQ0FBQztRQUM5QixJQUFJLENBQUMsUUFBUSxHQUFHLE1BQU0sQ0FBQyxRQUFRLENBQUM7UUFDaEMsSUFBSSxDQUFDLFVBQVUsR0FBRyxNQUFNLENBQUMsVUFBVSxDQUFDO1FBQ3BDLElBQUksQ0FBQyxVQUFVLEdBQUcsTUFBTSxDQUFDLFVBQVUsQ0FBQztRQUNwQyxJQUFJLENBQUMsUUFBUSxHQUFHLE1BQU0sQ0FBQyxRQUFRLENBQUM7UUFDaEMsSUFBSSxDQUFDLGNBQWMsR0FBRyxNQUFNLENBQUMsY0FBYyxDQUFDO1FBQzVDLElBQUksQ0FBQyxJQUFJLEdBQUcsTUFBTSxDQUFDLElBQUksQ0FBQztJQUMxQixDQUFDOzs7OztJQUtELFVBQVUsQ0FBQyxLQUFLOztjQUNSLFdBQVcsR0FBRyxJQUFJLENBQUMsZUFBZSxDQUFDLFNBQVMsQ0FBQyxLQUFLLENBQUM7UUFDekQsSUFBSSxDQUFDLEtBQUssR0FBRyxXQUFXLENBQUMsQ0FBQyxDQUFDLElBQUksT0FBTyxDQUFDLFdBQVcsQ0FBQyxJQUFJLEVBQUUsV0FBVyxDQUFDLE1BQU0sRUFBRSxXQUFXLENBQUMsTUFBTSxDQUFDLENBQUMsQ0FBQyxDQUFDLElBQUksT0FBTyxFQUFFLENBQUM7UUFDakgsSUFBSSxDQUFDLElBQUksQ0FBQyxPQUFPLElBQUksQ0FBQyxDQUFDLFdBQVcsSUFBSSxDQUFDLFFBQVEsQ0FBQyxXQUFXLENBQUMsTUFBTSxDQUFDLENBQUMsRUFBRTtZQUNwRSxJQUFJLENBQUMsS0FBSyxDQUFDLE1BQU0sR0FBRyxDQUFDLENBQUM7U0FDdkI7SUFDSCxDQUFDOzs7OztJQUVELGdCQUFnQixDQUFDLEVBQXVCLElBQVUsSUFBSSxDQUFDLFFBQVEsR0FBRyxFQUFFLENBQUMsQ0FBQyxDQUFDOzs7OztJQUV2RSxpQkFBaUIsQ0FBQyxFQUFhLElBQVUsSUFBSSxDQUFDLFNBQVMsR0FBRyxFQUFFLENBQUMsQ0FBQyxDQUFDOzs7OztJQUUvRCxnQkFBZ0IsQ0FBQyxVQUFtQixJQUFJLElBQUksQ0FBQyxRQUFRLEdBQUcsVUFBVSxDQUFDLENBQUMsQ0FBQzs7Ozs7SUFFckUsVUFBVSxDQUFDLElBQVk7UUFDckIsSUFBSSxDQUFDLEtBQUssQ0FBQyxVQUFVLENBQUMsSUFBSSxDQUFDLENBQUM7UUFDNUIsSUFBSSxDQUFDLG9CQUFvQixFQUFFLENBQUM7SUFDOUIsQ0FBQzs7Ozs7SUFFRCxZQUFZLENBQUMsSUFBWTtRQUN2QixJQUFJLENBQUMsS0FBSyxDQUFDLFlBQVksQ0FBQyxJQUFJLENBQUMsQ0FBQztRQUM5QixJQUFJLENBQUMsb0JBQW9CLEVBQUUsQ0FBQztJQUM5QixDQUFDOzs7OztJQUVELFlBQVksQ0FBQyxJQUFZO1FBQ3ZCLElBQUksQ0FBQyxLQUFLLENBQUMsWUFBWSxDQUFDLElBQUksQ0FBQyxDQUFDO1FBQzlCLElBQUksQ0FBQyxvQkFBb0IsRUFBRSxDQUFDO0lBQzlCLENBQUM7Ozs7O0lBRUQsVUFBVSxDQUFDLE1BQWM7O2NBQ2pCLElBQUksR0FBRyxJQUFJLENBQUMsS0FBSyxDQUFDLElBQUksSUFBSSxFQUFFOztjQUM1QixXQUFXLEdBQUcsU0FBUyxDQUFDLE1BQU0sQ0FBQztRQUNyQyxJQUFJLElBQUksQ0FBQyxRQUFRLElBQUksQ0FBQyxJQUFJLElBQUksV0FBVyxHQUFHLEVBQUUsSUFBSSxDQUFDLElBQUksSUFBSSxXQUFXLEtBQUssRUFBRSxDQUFDLEVBQUU7WUFDOUUsSUFBSSxDQUFDLEtBQUssQ0FBQyxVQUFVLENBQUMsV0FBVyxHQUFHLEVBQUUsQ0FBQyxDQUFDO1NBQ3pDO2FBQU07WUFDTCxJQUFJLENBQUMsS0FBSyxDQUFDLFVBQVUsQ0FBQyxXQUFXLENBQUMsQ0FBQztTQUNwQztRQUNELElBQUksQ0FBQyxvQkFBb0IsRUFBRSxDQUFDO0lBQzlCLENBQUM7Ozs7O0lBRUQsWUFBWSxDQUFDLE1BQWM7UUFDekIsSUFBSSxDQUFDLEtBQUssQ0FBQyxZQUFZLENBQUMsU0FBUyxDQUFDLE1BQU0sQ0FBQyxDQUFDLENBQUM7UUFDM0MsSUFBSSxDQUFDLG9CQUFvQixFQUFFLENBQUM7SUFDOUIsQ0FBQzs7Ozs7SUFFRCxZQUFZLENBQUMsTUFBYztRQUN6QixJQUFJLENBQUMsS0FBSyxDQUFDLFlBQVksQ0FBQyxTQUFTLENBQUMsTUFBTSxDQUFDLENBQUMsQ0FBQztRQUMzQyxJQUFJLENBQUMsb0JBQW9CLEVBQUUsQ0FBQztJQUM5QixDQUFDOzs7O0lBRUQsY0FBYztRQUNaLElBQUksSUFBSSxDQUFDLFFBQVEsRUFBRTtZQUNqQixJQUFJLENBQUMsVUFBVSxDQUFDLEVBQUUsQ0FBQyxDQUFDO1NBQ3JCO0lBQ0gsQ0FBQzs7Ozs7SUFFRCxVQUFVLENBQUMsS0FBYTtRQUN0QixJQUFJLFFBQVEsQ0FBQyxLQUFLLENBQUMsRUFBRTtZQUNuQixJQUFJLElBQUksQ0FBQyxRQUFRLEVBQUU7Z0JBQ2pCLE9BQU8sU0FBUyxDQUFDLEtBQUssR0FBRyxFQUFFLEtBQUssQ0FBQyxDQUFDLENBQUMsQ0FBQyxFQUFFLENBQUMsQ0FBQyxDQUFDLEtBQUssR0FBRyxFQUFFLENBQUMsQ0FBQzthQUN0RDtpQkFBTTtnQkFDTCxPQUFPLFNBQVMsQ0FBQyxLQUFLLEdBQUcsRUFBRSxDQUFDLENBQUM7YUFDOUI7U0FDRjthQUFNO1lBQ0wsT0FBTyxTQUFTLENBQUMsR0FBRyxDQUFDLENBQUM7U0FDdkI7SUFDSCxDQUFDOzs7OztJQUVELFlBQVksQ0FBQyxLQUFhLElBQUksT0FBTyxTQUFTLENBQUMsS0FBSyxDQUFDLENBQUMsQ0FBQyxDQUFDOzs7O0lBRXhELElBQUksV0FBVyxLQUFjLE9BQU8sSUFBSSxDQUFDLElBQUksS0FBSyxPQUFPLENBQUMsQ0FBQyxDQUFDOzs7O0lBRTVELElBQUksV0FBVyxLQUFjLE9BQU8sSUFBSSxDQUFDLElBQUksS0FBSyxPQUFPLENBQUMsQ0FBQyxDQUFDOzs7OztJQUU1RCxXQUFXLENBQUMsT0FBc0I7UUFDaEMsSUFBSSxPQUFPLENBQUMsU0FBUyxDQUFDLElBQUksQ0FBQyxJQUFJLENBQUMsT0FBTyxJQUFJLElBQUksQ0FBQyxLQUFLLElBQUksQ0FBQyxRQUFRLENBQUMsSUFBSSxDQUFDLEtBQUssQ0FBQyxNQUFNLENBQUMsRUFBRTtZQUNyRixJQUFJLENBQUMsS0FBSyxDQUFDLE1BQU0sR0FBRyxDQUFDLENBQUM7WUFDdEIsSUFBSSxDQUFDLG9CQUFvQixDQUFDLEtBQUssQ0FBQyxDQUFDO1NBQ2xDO0lBQ0gsQ0FBQzs7Ozs7SUFFTyxvQkFBb0IsQ0FBQyxPQUFPLEdBQUcsSUFBSTtRQUN6QyxJQUFJLE9BQU8sRUFBRTtZQUNYLElBQUksQ0FBQyxTQUFTLEVBQUUsQ0FBQztTQUNsQjtRQUNELElBQUksSUFBSSxDQUFDLEtBQUssQ0FBQyxPQUFPLENBQUMsSUFBSSxDQUFDLE9BQU8sQ0FBQyxFQUFFO1lBQ3BDLElBQUksQ0FBQyxRQUFRLENBQ1QsSUFBSSxDQUFDLGVBQWUsQ0FBQyxPQUFPLENBQUMsRUFBQyxJQUFJLEVBQUUsSUFBSSxDQUFDLEtBQUssQ0FBQyxJQUFJLEVBQUUsTUFBTSxFQUFFLElBQUksQ0FBQyxLQUFLLENBQUMsTUFBTSxFQUFFLE1BQU0sRUFBRSxJQUFJLENBQUMsS0FBSyxDQUFDLE1BQU0sRUFBQyxDQUFDLENBQUMsQ0FBQztTQUNsSDthQUFNO1lBQ0wsSUFBSSxDQUFDLFFBQVEsQ0FBQyxJQUFJLENBQUMsZUFBZSxDQUFDLE9BQU8sQ0FBQyxJQUFJLENBQUMsQ0FBQyxDQUFDO1NBQ25EO0lBQ0gsQ0FBQzs7O1lBbk9GLFNBQVMsU0FBQztnQkFDVCxRQUFRLEVBQUUsZ0JBQWdCO2dCQUUxQixRQUFRLEVBQUU7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7R0FzRVQ7Z0JBQ0QsU0FBUyxFQUFFLENBQUMsNkJBQTZCLENBQUM7O2FBQzNDOzs7O1lBdkZPLG1CQUFtQjtZQUNuQixjQUFjOzs7dUJBK0ZuQixLQUFLO3VCQUtMLEtBQUs7c0JBS0wsS0FBSzt1QkFLTCxLQUFLO3lCQUtMLEtBQUs7eUJBS0wsS0FBSzs2QkFLTCxLQUFLO21CQUtMLEtBQUs7Ozs7SUF6Q04saUNBQWtCOztJQUNsQiw4QkFBZTs7Ozs7SUFLZixpQ0FBMkI7Ozs7O0lBSzNCLGlDQUEyQjs7Ozs7SUFLM0IsZ0NBQTBCOzs7OztJQUsxQixpQ0FBMEI7Ozs7O0lBSzFCLG1DQUE0Qjs7Ozs7SUFLNUIsbUNBQTRCOzs7OztJQUs1Qix1Q0FBaUM7Ozs7O0lBS2pDLDZCQUE0Qzs7SUFjNUMsaUNBQTBCOztJQUMxQixrQ0FBcUI7O0lBYm9CLHdDQUE0QyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7Q29tcG9uZW50LCBmb3J3YXJkUmVmLCBJbnB1dCwgT25DaGFuZ2VzLCBTaW1wbGVDaGFuZ2VzfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7Q29udHJvbFZhbHVlQWNjZXNzb3IsIE5HX1ZBTFVFX0FDQ0VTU09SfSBmcm9tICdAYW5ndWxhci9mb3Jtcyc7XG5cbmltcG9ydCB7aXNOdW1iZXIsIHBhZE51bWJlciwgdG9JbnRlZ2VyfSBmcm9tICcuLi91dGlsL3V0aWwnO1xuaW1wb3J0IHtOZ2JUaW1lfSBmcm9tICcuL25nYi10aW1lJztcbmltcG9ydCB7TmdiVGltZXBpY2tlckNvbmZpZ30gZnJvbSAnLi90aW1lcGlja2VyLWNvbmZpZyc7XG5pbXBvcnQge05nYlRpbWVBZGFwdGVyfSBmcm9tICcuL25nYi10aW1lLWFkYXB0ZXInO1xuXG5jb25zdCBOR0JfVElNRVBJQ0tFUl9WQUxVRV9BQ0NFU1NPUiA9IHtcbiAgcHJvdmlkZTogTkdfVkFMVUVfQUNDRVNTT1IsXG4gIHVzZUV4aXN0aW5nOiBmb3J3YXJkUmVmKCgpID0+IE5nYlRpbWVwaWNrZXIpLFxuICBtdWx0aTogdHJ1ZVxufTtcblxuLyoqXG4gKiBBIGxpZ2h0d2VpZ2h0ICYgY29uZmlndXJhYmxlIHRpbWVwaWNrZXIgZGlyZWN0aXZlLlxuICovXG5AQ29tcG9uZW50KHtcbiAgc2VsZWN0b3I6ICduZ2ItdGltZXBpY2tlcicsXG4gIHN0eWxlVXJsczogWycuL3RpbWVwaWNrZXIuc2NzcyddLFxuICB0ZW1wbGF0ZTogYFxuICAgIDxmaWVsZHNldCBbZGlzYWJsZWRdPVwiZGlzYWJsZWRcIiBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIj5cbiAgICAgIDxkaXYgY2xhc3M9XCJuZ2ItdHBcIj5cbiAgICAgICAgPGRpdiBjbGFzcz1cIm5nYi10cC1pbnB1dC1jb250YWluZXIgbmdiLXRwLWhvdXJcIj5cbiAgICAgICAgICA8YnV0dG9uICpuZ0lmPVwic3Bpbm5lcnNcIiB0eXBlPVwiYnV0dG9uXCIgKGNsaWNrKT1cImNoYW5nZUhvdXIoaG91clN0ZXApXCJcbiAgICAgICAgICAgIGNsYXNzPVwiYnRuIGJ0bi1saW5rXCIgW2NsYXNzLmJ0bi1zbV09XCJpc1NtYWxsU2l6ZVwiIFtjbGFzcy5idG4tbGddPVwiaXNMYXJnZVNpemVcIiBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIlxuICAgICAgICAgICAgW2Rpc2FibGVkXT1cImRpc2FibGVkXCI+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cImNoZXZyb25cIj48L3NwYW4+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cInNyLW9ubHlcIiBpMThuPVwiQEBuZ2IudGltZXBpY2tlci5pbmNyZW1lbnQtaG91cnNcIj5JbmNyZW1lbnQgaG91cnM8L3NwYW4+XG4gICAgICAgICAgPC9idXR0b24+XG4gICAgICAgICAgPGlucHV0IHR5cGU9XCJ0ZXh0XCIgY2xhc3M9XCJmb3JtLWNvbnRyb2xcIiBbY2xhc3MuZm9ybS1jb250cm9sLXNtXT1cImlzU21hbGxTaXplXCIgW2NsYXNzLmZvcm0tY29udHJvbC1sZ109XCJpc0xhcmdlU2l6ZVwiIG1heGxlbmd0aD1cIjJcIlxuICAgICAgICAgICAgcGxhY2Vob2xkZXI9XCJISFwiIGkxOG4tcGxhY2Vob2xkZXI9XCJAQG5nYi50aW1lcGlja2VyLkhIXCJcbiAgICAgICAgICAgIFt2YWx1ZV09XCJmb3JtYXRIb3VyKG1vZGVsPy5ob3VyKVwiIChjaGFuZ2UpPVwidXBkYXRlSG91cigkZXZlbnQudGFyZ2V0LnZhbHVlKVwiXG4gICAgICAgICAgICBbcmVhZG9ubHldPVwicmVhZG9ubHlJbnB1dHNcIiBbZGlzYWJsZWRdPVwiZGlzYWJsZWRcIiBhcmlhLWxhYmVsPVwiSG91cnNcIiBpMThuLWFyaWEtbGFiZWw9XCJAQG5nYi50aW1lcGlja2VyLmhvdXJzXCI+XG4gICAgICAgICAgPGJ1dHRvbiAqbmdJZj1cInNwaW5uZXJzXCIgdHlwZT1cImJ1dHRvblwiIChjbGljayk9XCJjaGFuZ2VIb3VyKC1ob3VyU3RlcClcIlxuICAgICAgICAgICAgY2xhc3M9XCJidG4gYnRuLWxpbmtcIiBbY2xhc3MuYnRuLXNtXT1cImlzU21hbGxTaXplXCIgW2NsYXNzLmJ0bi1sZ109XCJpc0xhcmdlU2l6ZVwiIFtjbGFzcy5kaXNhYmxlZF09XCJkaXNhYmxlZFwiXG4gICAgICAgICAgICBbZGlzYWJsZWRdPVwiZGlzYWJsZWRcIj5cbiAgICAgICAgICAgIDxzcGFuIGNsYXNzPVwiY2hldnJvbiBib3R0b21cIj48L3NwYW4+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cInNyLW9ubHlcIiBpMThuPVwiQEBuZ2IudGltZXBpY2tlci5kZWNyZW1lbnQtaG91cnNcIj5EZWNyZW1lbnQgaG91cnM8L3NwYW4+XG4gICAgICAgICAgPC9idXR0b24+XG4gICAgICAgIDwvZGl2PlxuICAgICAgICA8ZGl2IGNsYXNzPVwibmdiLXRwLXNwYWNlclwiPjo8L2Rpdj5cbiAgICAgICAgPGRpdiBjbGFzcz1cIm5nYi10cC1pbnB1dC1jb250YWluZXIgbmdiLXRwLW1pbnV0ZVwiPlxuICAgICAgICAgIDxidXR0b24gKm5nSWY9XCJzcGlubmVyc1wiIHR5cGU9XCJidXR0b25cIiAoY2xpY2spPVwiY2hhbmdlTWludXRlKG1pbnV0ZVN0ZXApXCJcbiAgICAgICAgICAgIGNsYXNzPVwiYnRuIGJ0bi1saW5rXCIgW2NsYXNzLmJ0bi1zbV09XCJpc1NtYWxsU2l6ZVwiIFtjbGFzcy5idG4tbGddPVwiaXNMYXJnZVNpemVcIiBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIlxuICAgICAgICAgICAgW2Rpc2FibGVkXT1cImRpc2FibGVkXCI+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cImNoZXZyb25cIj48L3NwYW4+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cInNyLW9ubHlcIiBpMThuPVwiQEBuZ2IudGltZXBpY2tlci5pbmNyZW1lbnQtbWludXRlc1wiPkluY3JlbWVudCBtaW51dGVzPC9zcGFuPlxuICAgICAgICAgIDwvYnV0dG9uPlxuICAgICAgICAgIDxpbnB1dCB0eXBlPVwidGV4dFwiIGNsYXNzPVwiZm9ybS1jb250cm9sXCIgW2NsYXNzLmZvcm0tY29udHJvbC1zbV09XCJpc1NtYWxsU2l6ZVwiIFtjbGFzcy5mb3JtLWNvbnRyb2wtbGddPVwiaXNMYXJnZVNpemVcIiBtYXhsZW5ndGg9XCIyXCJcbiAgICAgICAgICAgIHBsYWNlaG9sZGVyPVwiTU1cIiBpMThuLXBsYWNlaG9sZGVyPVwiQEBuZ2IudGltZXBpY2tlci5NTVwiXG4gICAgICAgICAgICBbdmFsdWVdPVwiZm9ybWF0TWluU2VjKG1vZGVsPy5taW51dGUpXCIgKGNoYW5nZSk9XCJ1cGRhdGVNaW51dGUoJGV2ZW50LnRhcmdldC52YWx1ZSlcIlxuICAgICAgICAgICAgW3JlYWRvbmx5XT1cInJlYWRvbmx5SW5wdXRzXCIgW2Rpc2FibGVkXT1cImRpc2FibGVkXCIgYXJpYS1sYWJlbD1cIk1pbnV0ZXNcIiBpMThuLWFyaWEtbGFiZWw9XCJAQG5nYi50aW1lcGlja2VyLm1pbnV0ZXNcIj5cbiAgICAgICAgICA8YnV0dG9uICpuZ0lmPVwic3Bpbm5lcnNcIiB0eXBlPVwiYnV0dG9uXCIgKGNsaWNrKT1cImNoYW5nZU1pbnV0ZSgtbWludXRlU3RlcClcIlxuICAgICAgICAgICAgY2xhc3M9XCJidG4gYnRuLWxpbmtcIiBbY2xhc3MuYnRuLXNtXT1cImlzU21hbGxTaXplXCIgW2NsYXNzLmJ0bi1sZ109XCJpc0xhcmdlU2l6ZVwiICBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIlxuICAgICAgICAgICAgW2Rpc2FibGVkXT1cImRpc2FibGVkXCI+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cImNoZXZyb24gYm90dG9tXCI+PC9zcGFuPlxuICAgICAgICAgICAgPHNwYW4gY2xhc3M9XCJzci1vbmx5XCIgIGkxOG49XCJAQG5nYi50aW1lcGlja2VyLmRlY3JlbWVudC1taW51dGVzXCI+RGVjcmVtZW50IG1pbnV0ZXM8L3NwYW4+XG4gICAgICAgICAgPC9idXR0b24+XG4gICAgICAgIDwvZGl2PlxuICAgICAgICA8ZGl2ICpuZ0lmPVwic2Vjb25kc1wiIGNsYXNzPVwibmdiLXRwLXNwYWNlclwiPjo8L2Rpdj5cbiAgICAgICAgPGRpdiAqbmdJZj1cInNlY29uZHNcIiBjbGFzcz1cIm5nYi10cC1pbnB1dC1jb250YWluZXIgbmdiLXRwLXNlY29uZFwiPlxuICAgICAgICAgIDxidXR0b24gKm5nSWY9XCJzcGlubmVyc1wiIHR5cGU9XCJidXR0b25cIiAoY2xpY2spPVwiY2hhbmdlU2Vjb25kKHNlY29uZFN0ZXApXCJcbiAgICAgICAgICAgIGNsYXNzPVwiYnRuIGJ0bi1saW5rXCIgW2NsYXNzLmJ0bi1zbV09XCJpc1NtYWxsU2l6ZVwiIFtjbGFzcy5idG4tbGddPVwiaXNMYXJnZVNpemVcIiBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIlxuICAgICAgICAgICAgW2Rpc2FibGVkXT1cImRpc2FibGVkXCI+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cImNoZXZyb25cIj48L3NwYW4+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cInNyLW9ubHlcIiBpMThuPVwiQEBuZ2IudGltZXBpY2tlci5pbmNyZW1lbnQtc2Vjb25kc1wiPkluY3JlbWVudCBzZWNvbmRzPC9zcGFuPlxuICAgICAgICAgIDwvYnV0dG9uPlxuICAgICAgICAgIDxpbnB1dCB0eXBlPVwidGV4dFwiIGNsYXNzPVwiZm9ybS1jb250cm9sXCIgW2NsYXNzLmZvcm0tY29udHJvbC1zbV09XCJpc1NtYWxsU2l6ZVwiIFtjbGFzcy5mb3JtLWNvbnRyb2wtbGddPVwiaXNMYXJnZVNpemVcIiBtYXhsZW5ndGg9XCIyXCJcbiAgICAgICAgICAgIHBsYWNlaG9sZGVyPVwiU1NcIiBpMThuLXBsYWNlaG9sZGVyPVwiQEBuZ2IudGltZXBpY2tlci5TU1wiXG4gICAgICAgICAgICBbdmFsdWVdPVwiZm9ybWF0TWluU2VjKG1vZGVsPy5zZWNvbmQpXCIgKGNoYW5nZSk9XCJ1cGRhdGVTZWNvbmQoJGV2ZW50LnRhcmdldC52YWx1ZSlcIlxuICAgICAgICAgICAgW3JlYWRvbmx5XT1cInJlYWRvbmx5SW5wdXRzXCIgW2Rpc2FibGVkXT1cImRpc2FibGVkXCIgYXJpYS1sYWJlbD1cIlNlY29uZHNcIiBpMThuLWFyaWEtbGFiZWw9XCJAQG5nYi50aW1lcGlja2VyLnNlY29uZHNcIj5cbiAgICAgICAgICA8YnV0dG9uICpuZ0lmPVwic3Bpbm5lcnNcIiB0eXBlPVwiYnV0dG9uXCIgKGNsaWNrKT1cImNoYW5nZVNlY29uZCgtc2Vjb25kU3RlcClcIlxuICAgICAgICAgICAgY2xhc3M9XCJidG4gYnRuLWxpbmtcIiBbY2xhc3MuYnRuLXNtXT1cImlzU21hbGxTaXplXCIgW2NsYXNzLmJ0bi1sZ109XCJpc0xhcmdlU2l6ZVwiICBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIlxuICAgICAgICAgICAgW2Rpc2FibGVkXT1cImRpc2FibGVkXCI+XG4gICAgICAgICAgICA8c3BhbiBjbGFzcz1cImNoZXZyb24gYm90dG9tXCI+PC9zcGFuPlxuICAgICAgICAgICAgPHNwYW4gY2xhc3M9XCJzci1vbmx5XCIgaTE4bj1cIkBAbmdiLnRpbWVwaWNrZXIuZGVjcmVtZW50LXNlY29uZHNcIj5EZWNyZW1lbnQgc2Vjb25kczwvc3Bhbj5cbiAgICAgICAgICA8L2J1dHRvbj5cbiAgICAgICAgPC9kaXY+XG4gICAgICAgIDxkaXYgKm5nSWY9XCJtZXJpZGlhblwiIGNsYXNzPVwibmdiLXRwLXNwYWNlclwiPjwvZGl2PlxuICAgICAgICA8ZGl2ICpuZ0lmPVwibWVyaWRpYW5cIiBjbGFzcz1cIm5nYi10cC1tZXJpZGlhblwiPlxuICAgICAgICAgIDxidXR0b24gdHlwZT1cImJ1dHRvblwiIGNsYXNzPVwiYnRuIGJ0bi1vdXRsaW5lLXByaW1hcnlcIiBbY2xhc3MuYnRuLXNtXT1cImlzU21hbGxTaXplXCIgW2NsYXNzLmJ0bi1sZ109XCJpc0xhcmdlU2l6ZVwiXG4gICAgICAgICAgICBbZGlzYWJsZWRdPVwiZGlzYWJsZWRcIiBbY2xhc3MuZGlzYWJsZWRdPVwiZGlzYWJsZWRcIlxuICAgICAgICAgICAgICAgICAgKGNsaWNrKT1cInRvZ2dsZU1lcmlkaWFuKClcIj5cbiAgICAgICAgICAgIDxuZy1jb250YWluZXIgKm5nSWY9XCJtb2RlbD8uaG91ciA+PSAxMjsgZWxzZSBhbVwiIGkxOG49XCJAQG5nYi50aW1lcGlja2VyLlBNXCI+UE08L25nLWNvbnRhaW5lcj5cbiAgICAgICAgICAgIDxuZy10ZW1wbGF0ZSAjYW0gaTE4bj1cIkBAbmdiLnRpbWVwaWNrZXIuQU1cIj5BTTwvbmctdGVtcGxhdGU+XG4gICAgICAgICAgPC9idXR0b24+XG4gICAgICAgIDwvZGl2PlxuICAgICAgPC9kaXY+XG4gICAgPC9maWVsZHNldD5cbiAgYCxcbiAgcHJvdmlkZXJzOiBbTkdCX1RJTUVQSUNLRVJfVkFMVUVfQUNDRVNTT1JdXG59KVxuZXhwb3J0IGNsYXNzIE5nYlRpbWVwaWNrZXIgaW1wbGVtZW50cyBDb250cm9sVmFsdWVBY2Nlc3NvcixcbiAgICBPbkNoYW5nZXMge1xuICBkaXNhYmxlZDogYm9vbGVhbjtcbiAgbW9kZWw6IE5nYlRpbWU7XG5cbiAgLyoqXG4gICAqIFdoZXRoZXIgdG8gZGlzcGxheSAxMkggb3IgMjRIIG1vZGUuXG4gICAqL1xuICBASW5wdXQoKSBtZXJpZGlhbjogYm9vbGVhbjtcblxuICAvKipcbiAgICogV2hldGhlciB0byBkaXNwbGF5IHRoZSBzcGlubmVycyBhYm92ZSBhbmQgYmVsb3cgdGhlIGlucHV0cy5cbiAgICovXG4gIEBJbnB1dCgpIHNwaW5uZXJzOiBib29sZWFuO1xuXG4gIC8qKlxuICAgKiBXaGV0aGVyIHRvIGRpc3BsYXkgc2Vjb25kcyBpbnB1dC5cbiAgICovXG4gIEBJbnB1dCgpIHNlY29uZHM6IGJvb2xlYW47XG5cbiAgLyoqXG4gICAqIE51bWJlciBvZiBob3VycyB0byBpbmNyZWFzZSBvciBkZWNyZWFzZSB3aGVuIHVzaW5nIGEgYnV0dG9uLlxuICAgKi9cbiAgQElucHV0KCkgaG91clN0ZXA6IG51bWJlcjtcblxuICAvKipcbiAgICogTnVtYmVyIG9mIG1pbnV0ZXMgdG8gaW5jcmVhc2Ugb3IgZGVjcmVhc2Ugd2hlbiB1c2luZyBhIGJ1dHRvbi5cbiAgICovXG4gIEBJbnB1dCgpIG1pbnV0ZVN0ZXA6IG51bWJlcjtcblxuICAvKipcbiAgICogTnVtYmVyIG9mIHNlY29uZHMgdG8gaW5jcmVhc2Ugb3IgZGVjcmVhc2Ugd2hlbiB1c2luZyBhIGJ1dHRvbi5cbiAgICovXG4gIEBJbnB1dCgpIHNlY29uZFN0ZXA6IG51bWJlcjtcblxuICAvKipcbiAgICogVG8gbWFrZSB0aW1lcGlja2VyIHJlYWRvbmx5XG4gICAqL1xuICBASW5wdXQoKSByZWFkb25seUlucHV0czogYm9vbGVhbjtcblxuICAvKipcbiAgICogVG8gc2V0IHRoZSBzaXplIG9mIHRoZSBpbnB1dHMgYW5kIGJ1dHRvblxuICAgKi9cbiAgQElucHV0KCkgc2l6ZTogJ3NtYWxsJyB8ICdtZWRpdW0nIHwgJ2xhcmdlJztcblxuICBjb25zdHJ1Y3Rvcihjb25maWc6IE5nYlRpbWVwaWNrZXJDb25maWcsIHByaXZhdGUgX25nYlRpbWVBZGFwdGVyOiBOZ2JUaW1lQWRhcHRlcjxhbnk+KSB7XG4gICAgdGhpcy5tZXJpZGlhbiA9IGNvbmZpZy5tZXJpZGlhbjtcbiAgICB0aGlzLnNwaW5uZXJzID0gY29uZmlnLnNwaW5uZXJzO1xuICAgIHRoaXMuc2Vjb25kcyA9IGNvbmZpZy5zZWNvbmRzO1xuICAgIHRoaXMuaG91clN0ZXAgPSBjb25maWcuaG91clN0ZXA7XG4gICAgdGhpcy5taW51dGVTdGVwID0gY29uZmlnLm1pbnV0ZVN0ZXA7XG4gICAgdGhpcy5zZWNvbmRTdGVwID0gY29uZmlnLnNlY29uZFN0ZXA7XG4gICAgdGhpcy5kaXNhYmxlZCA9IGNvbmZpZy5kaXNhYmxlZDtcbiAgICB0aGlzLnJlYWRvbmx5SW5wdXRzID0gY29uZmlnLnJlYWRvbmx5SW5wdXRzO1xuICAgIHRoaXMuc2l6ZSA9IGNvbmZpZy5zaXplO1xuICB9XG5cbiAgb25DaGFuZ2UgPSAoXzogYW55KSA9PiB7fTtcbiAgb25Ub3VjaGVkID0gKCkgPT4ge307XG5cbiAgd3JpdGVWYWx1ZSh2YWx1ZSkge1xuICAgIGNvbnN0IHN0cnVjdFZhbHVlID0gdGhpcy5fbmdiVGltZUFkYXB0ZXIuZnJvbU1vZGVsKHZhbHVlKTtcbiAgICB0aGlzLm1vZGVsID0gc3RydWN0VmFsdWUgPyBuZXcgTmdiVGltZShzdHJ1Y3RWYWx1ZS5ob3VyLCBzdHJ1Y3RWYWx1ZS5taW51dGUsIHN0cnVjdFZhbHVlLnNlY29uZCkgOiBuZXcgTmdiVGltZSgpO1xuICAgIGlmICghdGhpcy5zZWNvbmRzICYmICghc3RydWN0VmFsdWUgfHwgIWlzTnVtYmVyKHN0cnVjdFZhbHVlLnNlY29uZCkpKSB7XG4gICAgICB0aGlzLm1vZGVsLnNlY29uZCA9IDA7XG4gICAgfVxuICB9XG5cbiAgcmVnaXN0ZXJPbkNoYW5nZShmbjogKHZhbHVlOiBhbnkpID0+IGFueSk6IHZvaWQgeyB0aGlzLm9uQ2hhbmdlID0gZm47IH1cblxuICByZWdpc3Rlck9uVG91Y2hlZChmbjogKCkgPT4gYW55KTogdm9pZCB7IHRoaXMub25Ub3VjaGVkID0gZm47IH1cblxuICBzZXREaXNhYmxlZFN0YXRlKGlzRGlzYWJsZWQ6IGJvb2xlYW4pIHsgdGhpcy5kaXNhYmxlZCA9IGlzRGlzYWJsZWQ7IH1cblxuICBjaGFuZ2VIb3VyKHN0ZXA6IG51bWJlcikge1xuICAgIHRoaXMubW9kZWwuY2hhbmdlSG91cihzdGVwKTtcbiAgICB0aGlzLnByb3BhZ2F0ZU1vZGVsQ2hhbmdlKCk7XG4gIH1cblxuICBjaGFuZ2VNaW51dGUoc3RlcDogbnVtYmVyKSB7XG4gICAgdGhpcy5tb2RlbC5jaGFuZ2VNaW51dGUoc3RlcCk7XG4gICAgdGhpcy5wcm9wYWdhdGVNb2RlbENoYW5nZSgpO1xuICB9XG5cbiAgY2hhbmdlU2Vjb25kKHN0ZXA6IG51bWJlcikge1xuICAgIHRoaXMubW9kZWwuY2hhbmdlU2Vjb25kKHN0ZXApO1xuICAgIHRoaXMucHJvcGFnYXRlTW9kZWxDaGFuZ2UoKTtcbiAgfVxuXG4gIHVwZGF0ZUhvdXIobmV3VmFsOiBzdHJpbmcpIHtcbiAgICBjb25zdCBpc1BNID0gdGhpcy5tb2RlbC5ob3VyID49IDEyO1xuICAgIGNvbnN0IGVudGVyZWRIb3VyID0gdG9JbnRlZ2VyKG5ld1ZhbCk7XG4gICAgaWYgKHRoaXMubWVyaWRpYW4gJiYgKGlzUE0gJiYgZW50ZXJlZEhvdXIgPCAxMiB8fCAhaXNQTSAmJiBlbnRlcmVkSG91ciA9PT0gMTIpKSB7XG4gICAgICB0aGlzLm1vZGVsLnVwZGF0ZUhvdXIoZW50ZXJlZEhvdXIgKyAxMik7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMubW9kZWwudXBkYXRlSG91cihlbnRlcmVkSG91cik7XG4gICAgfVxuICAgIHRoaXMucHJvcGFnYXRlTW9kZWxDaGFuZ2UoKTtcbiAgfVxuXG4gIHVwZGF0ZU1pbnV0ZShuZXdWYWw6IHN0cmluZykge1xuICAgIHRoaXMubW9kZWwudXBkYXRlTWludXRlKHRvSW50ZWdlcihuZXdWYWwpKTtcbiAgICB0aGlzLnByb3BhZ2F0ZU1vZGVsQ2hhbmdlKCk7XG4gIH1cblxuICB1cGRhdGVTZWNvbmQobmV3VmFsOiBzdHJpbmcpIHtcbiAgICB0aGlzLm1vZGVsLnVwZGF0ZVNlY29uZCh0b0ludGVnZXIobmV3VmFsKSk7XG4gICAgdGhpcy5wcm9wYWdhdGVNb2RlbENoYW5nZSgpO1xuICB9XG5cbiAgdG9nZ2xlTWVyaWRpYW4oKSB7XG4gICAgaWYgKHRoaXMubWVyaWRpYW4pIHtcbiAgICAgIHRoaXMuY2hhbmdlSG91cigxMik7XG4gICAgfVxuICB9XG5cbiAgZm9ybWF0SG91cih2YWx1ZTogbnVtYmVyKSB7XG4gICAgaWYgKGlzTnVtYmVyKHZhbHVlKSkge1xuICAgICAgaWYgKHRoaXMubWVyaWRpYW4pIHtcbiAgICAgICAgcmV0dXJuIHBhZE51bWJlcih2YWx1ZSAlIDEyID09PSAwID8gMTIgOiB2YWx1ZSAlIDEyKTtcbiAgICAgIH0gZWxzZSB7XG4gICAgICAgIHJldHVybiBwYWROdW1iZXIodmFsdWUgJSAyNCk7XG4gICAgICB9XG4gICAgfSBlbHNlIHtcbiAgICAgIHJldHVybiBwYWROdW1iZXIoTmFOKTtcbiAgICB9XG4gIH1cblxuICBmb3JtYXRNaW5TZWModmFsdWU6IG51bWJlcikgeyByZXR1cm4gcGFkTnVtYmVyKHZhbHVlKTsgfVxuXG4gIGdldCBpc1NtYWxsU2l6ZSgpOiBib29sZWFuIHsgcmV0dXJuIHRoaXMuc2l6ZSA9PT0gJ3NtYWxsJzsgfVxuXG4gIGdldCBpc0xhcmdlU2l6ZSgpOiBib29sZWFuIHsgcmV0dXJuIHRoaXMuc2l6ZSA9PT0gJ2xhcmdlJzsgfVxuXG4gIG5nT25DaGFuZ2VzKGNoYW5nZXM6IFNpbXBsZUNoYW5nZXMpOiB2b2lkIHtcbiAgICBpZiAoY2hhbmdlc1snc2Vjb25kcyddICYmICF0aGlzLnNlY29uZHMgJiYgdGhpcy5tb2RlbCAmJiAhaXNOdW1iZXIodGhpcy5tb2RlbC5zZWNvbmQpKSB7XG4gICAgICB0aGlzLm1vZGVsLnNlY29uZCA9IDA7XG4gICAgICB0aGlzLnByb3BhZ2F0ZU1vZGVsQ2hhbmdlKGZhbHNlKTtcbiAgICB9XG4gIH1cblxuICBwcml2YXRlIHByb3BhZ2F0ZU1vZGVsQ2hhbmdlKHRvdWNoZWQgPSB0cnVlKSB7XG4gICAgaWYgKHRvdWNoZWQpIHtcbiAgICAgIHRoaXMub25Ub3VjaGVkKCk7XG4gICAgfVxuICAgIGlmICh0aGlzLm1vZGVsLmlzVmFsaWQodGhpcy5zZWNvbmRzKSkge1xuICAgICAgdGhpcy5vbkNoYW5nZShcbiAgICAgICAgICB0aGlzLl9uZ2JUaW1lQWRhcHRlci50b01vZGVsKHtob3VyOiB0aGlzLm1vZGVsLmhvdXIsIG1pbnV0ZTogdGhpcy5tb2RlbC5taW51dGUsIHNlY29uZDogdGhpcy5tb2RlbC5zZWNvbmR9KSk7XG4gICAgfSBlbHNlIHtcbiAgICAgIHRoaXMub25DaGFuZ2UodGhpcy5fbmdiVGltZUFkYXB0ZXIudG9Nb2RlbChudWxsKSk7XG4gICAgfVxuICB9XG59XG4iXX0=