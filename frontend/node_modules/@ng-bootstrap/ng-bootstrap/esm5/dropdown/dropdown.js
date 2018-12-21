/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import * as tslib_1 from "tslib";
import { forwardRef, Inject, Directive, Input, Output, EventEmitter, ElementRef, ContentChild, NgZone, Renderer2, ChangeDetectorRef } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { fromEvent, race, Subject } from 'rxjs';
import { filter, takeUntil } from 'rxjs/operators';
import { NgbDropdownConfig } from './dropdown-config';
import { positionElements } from '../util/positioning';
import { Key } from '../util/key';
/**
 *
 */
var NgbDropdownMenu = /** @class */ (function () {
    function NgbDropdownMenu(dropdown, _elementRef, _renderer) {
        this.dropdown = dropdown;
        this._elementRef = _elementRef;
        this._renderer = _renderer;
        this.placement = 'bottom';
        this.isOpen = false;
    }
    /**
     * @param {?} $event
     * @return {?}
     */
    NgbDropdownMenu.prototype.isEventFrom = /**
     * @param {?} $event
     * @return {?}
     */
    function ($event) { return this._elementRef.nativeElement.contains($event.target); };
    /**
     * @param {?} triggerEl
     * @param {?} placement
     * @return {?}
     */
    NgbDropdownMenu.prototype.position = /**
     * @param {?} triggerEl
     * @param {?} placement
     * @return {?}
     */
    function (triggerEl, placement) {
        this.applyPlacement(positionElements(triggerEl, this._elementRef.nativeElement, placement));
    };
    /**
     * @param {?} _placement
     * @return {?}
     */
    NgbDropdownMenu.prototype.applyPlacement = /**
     * @param {?} _placement
     * @return {?}
     */
    function (_placement) {
        // remove the current placement classes
        this._renderer.removeClass(this._elementRef.nativeElement.parentNode, 'dropup');
        this._renderer.removeClass(this._elementRef.nativeElement.parentNode, 'dropdown');
        this.placement = _placement;
        /**
         * apply the new placement
         * in case of top use up-arrow or down-arrow otherwise
         */
        if (_placement.search('^top') !== -1) {
            this._renderer.addClass(this._elementRef.nativeElement.parentNode, 'dropup');
        }
        else {
            this._renderer.addClass(this._elementRef.nativeElement.parentNode, 'dropdown');
        }
    };
    NgbDropdownMenu.decorators = [
        { type: Directive, args: [{
                    selector: '[ngbDropdownMenu]',
                    host: { '[class.dropdown-menu]': 'true', '[class.show]': 'dropdown.isOpen()', '[attr.x-placement]': 'placement' }
                },] }
    ];
    /** @nocollapse */
    NgbDropdownMenu.ctorParameters = function () { return [
        { type: undefined, decorators: [{ type: Inject, args: [forwardRef(function () { return NgbDropdown; }),] }] },
        { type: ElementRef },
        { type: Renderer2 }
    ]; };
    return NgbDropdownMenu;
}());
export { NgbDropdownMenu };
if (false) {
    /** @type {?} */
    NgbDropdownMenu.prototype.placement;
    /** @type {?} */
    NgbDropdownMenu.prototype.isOpen;
    /** @type {?} */
    NgbDropdownMenu.prototype.dropdown;
    /** @type {?} */
    NgbDropdownMenu.prototype._elementRef;
    /** @type {?} */
    NgbDropdownMenu.prototype._renderer;
}
/**
 * Marks an element to which dropdown menu will be anchored. This is a simple version
 * of the NgbDropdownToggle directive. It plays the same role as NgbDropdownToggle but
 * doesn't listen to click events to toggle dropdown menu thus enabling support for
 * events other than click.
 *
 * \@since 1.1.0
 */
var NgbDropdownAnchor = /** @class */ (function () {
    function NgbDropdownAnchor(dropdown, _elementRef) {
        this.dropdown = dropdown;
        this._elementRef = _elementRef;
        this.anchorEl = _elementRef.nativeElement;
    }
    /**
     * @param {?} $event
     * @return {?}
     */
    NgbDropdownAnchor.prototype.isEventFrom = /**
     * @param {?} $event
     * @return {?}
     */
    function ($event) { return this._elementRef.nativeElement.contains($event.target); };
    NgbDropdownAnchor.decorators = [
        { type: Directive, args: [{
                    selector: '[ngbDropdownAnchor]',
                    host: { 'class': 'dropdown-toggle', 'aria-haspopup': 'true', '[attr.aria-expanded]': 'dropdown.isOpen()' }
                },] }
    ];
    /** @nocollapse */
    NgbDropdownAnchor.ctorParameters = function () { return [
        { type: undefined, decorators: [{ type: Inject, args: [forwardRef(function () { return NgbDropdown; }),] }] },
        { type: ElementRef }
    ]; };
    return NgbDropdownAnchor;
}());
export { NgbDropdownAnchor };
if (false) {
    /** @type {?} */
    NgbDropdownAnchor.prototype.anchorEl;
    /** @type {?} */
    NgbDropdownAnchor.prototype.dropdown;
    /** @type {?} */
    NgbDropdownAnchor.prototype._elementRef;
}
/**
 * Allows the dropdown to be toggled via click. This directive is optional: you can use NgbDropdownAnchor as an
 * alternative.
 */
var NgbDropdownToggle = /** @class */ (function (_super) {
    tslib_1.__extends(NgbDropdownToggle, _super);
    function NgbDropdownToggle(dropdown, elementRef) {
        return _super.call(this, dropdown, elementRef) || this;
    }
    /**
     * @return {?}
     */
    NgbDropdownToggle.prototype.toggleOpen = /**
     * @return {?}
     */
    function () { this.dropdown.toggle(); };
    NgbDropdownToggle.decorators = [
        { type: Directive, args: [{
                    selector: '[ngbDropdownToggle]',
                    host: {
                        'class': 'dropdown-toggle',
                        'aria-haspopup': 'true',
                        '[attr.aria-expanded]': 'dropdown.isOpen()',
                        '(click)': 'toggleOpen()'
                    },
                    providers: [{ provide: NgbDropdownAnchor, useExisting: forwardRef(function () { return NgbDropdownToggle; }) }]
                },] }
    ];
    /** @nocollapse */
    NgbDropdownToggle.ctorParameters = function () { return [
        { type: undefined, decorators: [{ type: Inject, args: [forwardRef(function () { return NgbDropdown; }),] }] },
        { type: ElementRef }
    ]; };
    return NgbDropdownToggle;
}(NgbDropdownAnchor));
export { NgbDropdownToggle };
/**
 * Transforms a node into a dropdown.
 */
var NgbDropdown = /** @class */ (function () {
    function NgbDropdown(_changeDetector, config, _document, _ngZone) {
        var _this = this;
        this._changeDetector = _changeDetector;
        this._document = _document;
        this._ngZone = _ngZone;
        this._closed$ = new Subject();
        /**
         *  Defines whether or not the dropdown-menu is open initially.
         */
        this._open = false;
        /**
         *  An event fired when the dropdown is opened or closed.
         *  Event's payload equals whether dropdown is open.
         */
        this.openChange = new EventEmitter();
        this.placement = config.placement;
        this.autoClose = config.autoClose;
        this._zoneSubscription = _ngZone.onStable.subscribe(function () { _this._positionMenu(); });
    }
    /**
     * @return {?}
     */
    NgbDropdown.prototype.ngOnInit = /**
     * @return {?}
     */
    function () {
        if (this._menu) {
            this._menu.applyPlacement(Array.isArray(this.placement) ? (this.placement[0]) : (/** @type {?} */ (this.placement)));
        }
        if (this._open) {
            this._setCloseHandlers();
        }
    };
    /**
     * Checks if the dropdown menu is open or not.
     */
    /**
     * Checks if the dropdown menu is open or not.
     * @return {?}
     */
    NgbDropdown.prototype.isOpen = /**
     * Checks if the dropdown menu is open or not.
     * @return {?}
     */
    function () { return this._open; };
    /**
     * Opens the dropdown menu of a given navbar or tabbed navigation.
     */
    /**
     * Opens the dropdown menu of a given navbar or tabbed navigation.
     * @return {?}
     */
    NgbDropdown.prototype.open = /**
     * Opens the dropdown menu of a given navbar or tabbed navigation.
     * @return {?}
     */
    function () {
        if (!this._open) {
            this._open = true;
            this._positionMenu();
            this.openChange.emit(true);
            this._setCloseHandlers();
        }
    };
    /**
     * @return {?}
     */
    NgbDropdown.prototype._setCloseHandlers = /**
     * @return {?}
     */
    function () {
        var _this = this;
        if (this.autoClose) {
            this._ngZone.runOutsideAngular(function () {
                /** @type {?} */
                var escapes$ = fromEvent(_this._document, 'keyup')
                    .pipe(takeUntil(_this._closed$), 
                // tslint:disable-next-line:deprecation
                filter(function (event) { return event.which === Key.Escape; }));
                /** @type {?} */
                var clicks$ = fromEvent(_this._document, 'click')
                    .pipe(takeUntil(_this._closed$), filter(function (event) { return _this._shouldCloseFromClick(event); }));
                race([escapes$, clicks$]).pipe(takeUntil(_this._closed$)).subscribe(function () { return _this._ngZone.run(function () {
                    _this.close();
                    _this._changeDetector.markForCheck();
                }); });
            });
        }
    };
    /**
     * Closes the dropdown menu of a given navbar or tabbed navigation.
     */
    /**
     * Closes the dropdown menu of a given navbar or tabbed navigation.
     * @return {?}
     */
    NgbDropdown.prototype.close = /**
     * Closes the dropdown menu of a given navbar or tabbed navigation.
     * @return {?}
     */
    function () {
        if (this._open) {
            this._open = false;
            this._closed$.next();
            this.openChange.emit(false);
        }
    };
    /**
     * Toggles the dropdown menu of a given navbar or tabbed navigation.
     */
    /**
     * Toggles the dropdown menu of a given navbar or tabbed navigation.
     * @return {?}
     */
    NgbDropdown.prototype.toggle = /**
     * Toggles the dropdown menu of a given navbar or tabbed navigation.
     * @return {?}
     */
    function () {
        if (this.isOpen()) {
            this.close();
        }
        else {
            this.open();
        }
    };
    /**
     * @param {?} event
     * @return {?}
     */
    NgbDropdown.prototype._shouldCloseFromClick = /**
     * @param {?} event
     * @return {?}
     */
    function (event) {
        if (event.button !== 2 && !this._isEventFromToggle(event)) {
            if (this.autoClose === true) {
                return true;
            }
            else if (this.autoClose === 'inside' && this._isEventFromMenu(event)) {
                return true;
            }
            else if (this.autoClose === 'outside' && !this._isEventFromMenu(event)) {
                return true;
            }
        }
        return false;
    };
    /**
     * @return {?}
     */
    NgbDropdown.prototype.ngOnDestroy = /**
     * @return {?}
     */
    function () {
        this._closed$.next();
        this._zoneSubscription.unsubscribe();
    };
    /**
     * @param {?} $event
     * @return {?}
     */
    NgbDropdown.prototype._isEventFromToggle = /**
     * @param {?} $event
     * @return {?}
     */
    function ($event) { return this._anchor.isEventFrom($event); };
    /**
     * @param {?} $event
     * @return {?}
     */
    NgbDropdown.prototype._isEventFromMenu = /**
     * @param {?} $event
     * @return {?}
     */
    function ($event) { return this._menu ? this._menu.isEventFrom($event) : false; };
    /**
     * @return {?}
     */
    NgbDropdown.prototype._positionMenu = /**
     * @return {?}
     */
    function () {
        if (this.isOpen() && this._menu) {
            this._menu.position(this._anchor.anchorEl, this.placement);
        }
    };
    NgbDropdown.decorators = [
        { type: Directive, args: [{ selector: '[ngbDropdown]', exportAs: 'ngbDropdown', host: { '[class.show]': 'isOpen()' } },] }
    ];
    /** @nocollapse */
    NgbDropdown.ctorParameters = function () { return [
        { type: ChangeDetectorRef },
        { type: NgbDropdownConfig },
        { type: undefined, decorators: [{ type: Inject, args: [DOCUMENT,] }] },
        { type: NgZone }
    ]; };
    NgbDropdown.propDecorators = {
        _menu: [{ type: ContentChild, args: [NgbDropdownMenu,] }],
        _anchor: [{ type: ContentChild, args: [NgbDropdownAnchor,] }],
        autoClose: [{ type: Input }],
        _open: [{ type: Input, args: ['open',] }],
        placement: [{ type: Input }],
        openChange: [{ type: Output }]
    };
    return NgbDropdown;
}());
export { NgbDropdown };
if (false) {
    /** @type {?} */
    NgbDropdown.prototype._closed$;
    /** @type {?} */
    NgbDropdown.prototype._zoneSubscription;
    /** @type {?} */
    NgbDropdown.prototype._menu;
    /** @type {?} */
    NgbDropdown.prototype._anchor;
    /**
     * Indicates that dropdown should be closed when selecting one of dropdown items (click) or pressing ESC.
     * When it is true (default) dropdowns are automatically closed on both outside and inside (menu) clicks.
     * When it is false dropdowns are never automatically closed.
     * When it is 'outside' dropdowns are automatically closed on outside clicks but not on menu clicks.
     * When it is 'inside' dropdowns are automatically on menu clicks but not on outside clicks.
     * @type {?}
     */
    NgbDropdown.prototype.autoClose;
    /**
     *  Defines whether or not the dropdown-menu is open initially.
     * @type {?}
     */
    NgbDropdown.prototype._open;
    /**
     * Placement of a popover accepts:
     *    "top", "top-left", "top-right", "bottom", "bottom-left", "bottom-right",
     *    "left", "left-top", "left-bottom", "right", "right-top", "right-bottom"
     * and array of above values.
     * @type {?}
     */
    NgbDropdown.prototype.placement;
    /**
     *  An event fired when the dropdown is opened or closed.
     *  Event's payload equals whether dropdown is open.
     * @type {?}
     */
    NgbDropdown.prototype.openChange;
    /** @type {?} */
    NgbDropdown.prototype._changeDetector;
    /** @type {?} */
    NgbDropdown.prototype._document;
    /** @type {?} */
    NgbDropdown.prototype._ngZone;
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiZHJvcGRvd24uanMiLCJzb3VyY2VSb290Ijoibmc6Ly9AbmctYm9vdHN0cmFwL25nLWJvb3RzdHJhcC8iLCJzb3VyY2VzIjpbImRyb3Bkb3duL2Ryb3Bkb3duLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7O0FBQUEsT0FBTyxFQUNMLFVBQVUsRUFDVixNQUFNLEVBQ04sU0FBUyxFQUNULEtBQUssRUFDTCxNQUFNLEVBQ04sWUFBWSxFQUNaLFVBQVUsRUFDVixZQUFZLEVBQ1osTUFBTSxFQUNOLFNBQVMsRUFHVCxpQkFBaUIsRUFDbEIsTUFBTSxlQUFlLENBQUM7QUFDdkIsT0FBTyxFQUFDLFFBQVEsRUFBQyxNQUFNLGlCQUFpQixDQUFDO0FBQ3pDLE9BQU8sRUFBQyxTQUFTLEVBQUUsSUFBSSxFQUFFLE9BQU8sRUFBZSxNQUFNLE1BQU0sQ0FBQztBQUM1RCxPQUFPLEVBQUMsTUFBTSxFQUFFLFNBQVMsRUFBQyxNQUFNLGdCQUFnQixDQUFDO0FBQ2pELE9BQU8sRUFBQyxpQkFBaUIsRUFBQyxNQUFNLG1CQUFtQixDQUFDO0FBQ3BELE9BQU8sRUFBQyxnQkFBZ0IsRUFBNEIsTUFBTSxxQkFBcUIsQ0FBQztBQUNoRixPQUFPLEVBQUMsR0FBRyxFQUFDLE1BQU0sYUFBYSxDQUFDOzs7O0FBSWhDO0lBUUUseUJBQ2tELFFBQVEsRUFBVSxXQUFvQyxFQUM1RixTQUFvQjtRQURrQixhQUFRLEdBQVIsUUFBUSxDQUFBO1FBQVUsZ0JBQVcsR0FBWCxXQUFXLENBQXlCO1FBQzVGLGNBQVMsR0FBVCxTQUFTLENBQVc7UUFMaEMsY0FBUyxHQUFjLFFBQVEsQ0FBQztRQUNoQyxXQUFNLEdBQUcsS0FBSyxDQUFDO0lBSW9CLENBQUM7Ozs7O0lBRXBDLHFDQUFXOzs7O0lBQVgsVUFBWSxNQUFNLElBQUksT0FBTyxJQUFJLENBQUMsV0FBVyxDQUFDLGFBQWEsQ0FBQyxRQUFRLENBQUMsTUFBTSxDQUFDLE1BQU0sQ0FBQyxDQUFDLENBQUMsQ0FBQzs7Ozs7O0lBRXRGLGtD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SCxDQUFDOztnQkE1SUYsU0FBUyxTQUFDLEVBQUMsUUFBUSxFQUFFLGVBQWUsRUFBRSxRQUFRLEVBQUUsYUFBYSxFQUFFLElBQUksRUFBRSxFQUFDLGNBQWMsRUFBRSxVQUFVLEVBQUMsRUFBQzs7OztnQkE3RmpHLGlCQUFpQjtnQkFLWCxpQkFBaUI7Z0RBOEhxRCxNQUFNLFNBQUMsUUFBUTtnQkF2STNGLE1BQU07Ozt3QkFzR0wsWUFBWSxTQUFDLGVBQWU7MEJBRTVCLFlBQVksU0FBQyxpQkFBaUI7NEJBUzlCLEtBQUs7d0JBS0wsS0FBSyxTQUFDLE1BQU07NEJBUVosS0FBSzs2QkFNTCxNQUFNOztJQTBHVCxrQkFBQztDQUFBLEFBN0lELElBNklDO1NBNUlZLFdBQVc7OztJQUN0QiwrQkFBdUM7O0lBQ3ZDLHdDQUF3Qzs7SUFFeEMsNEJBQThEOztJQUU5RCw4QkFBb0U7Ozs7Ozs7OztJQVNwRSxnQ0FBbUQ7Ozs7O0lBS25ELDRCQUE2Qjs7Ozs7Ozs7SUFRN0IsZ0NBQW1DOzs7Ozs7SUFNbkMsaUNBQTBDOztJQUd0QyxzQ0FBMEM7O0lBQTZCLGdDQUF3Qzs7SUFDL0csOEJBQXVCIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtcbiAgZm9yd2FyZFJlZixcbiAgSW5qZWN0LFxuICBEaXJlY3RpdmUsXG4gIElucHV0LFxuICBPdXRwdXQsXG4gIEV2ZW50RW1pdHRlcixcbiAgRWxlbWVudFJlZixcbiAgQ29udGVudENoaWxkLFxuICBOZ1pvbmUsXG4gIFJlbmRlcmVyMixcbiAgT25Jbml0LFxuICBPbkRlc3Ryb3ksXG4gIENoYW5nZURldGVjdG9yUmVmXG59IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuaW1wb3J0IHtET0NVTUVOVH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcbmltcG9ydCB7ZnJvbUV2ZW50LCByYWNlLCBTdWJqZWN0LCBTdWJzY3JpcHRpb259IGZyb20gJ3J4anMnO1xuaW1wb3J0IHtmaWx0ZXIsIHRha2VVbnRpbH0gZnJvbSAncnhqcy9vcGVyYXRvcnMnO1xuaW1wb3J0IHtOZ2JEcm9wZG93bkNvbmZpZ30gZnJvbSAnLi9kcm9wZG93bi1jb25maWcnO1xuaW1wb3J0IHtwb3NpdGlvbkVsZW1lbnRzLCBQbGFjZW1lbnRBcnJheSwgUGxhY2VtZW50fSBmcm9tICcuLi91dGlsL3Bvc2l0aW9uaW5nJztcbmltcG9ydCB7S2V5fSBmcm9tICcuLi91dGlsL2tleSc7XG5cbi8qKlxuICovXG5ARGlyZWN0aXZlKHtcbiAgc2VsZWN0b3I6ICdbbmdiRHJvcGRvd25NZW51XScsXG4gIGhvc3Q6IHsnW2NsYXNzLmRyb3Bkb3duLW1lbnVdJzogJ3RydWUnLCAnW2NsYXNzLnNob3ddJzogJ2Ryb3Bkb3duLmlzT3BlbigpJywgJ1thdHRyLngtcGxhY2VtZW50XSc6ICdwbGFjZW1lbnQnfVxufSlcbmV4cG9ydCBjbGFzcyBOZ2JEcm9wZG93bk1lbnUge1xuICBwbGFjZW1lbnQ6IFBsYWNlbWVudCA9ICdib3R0b20nO1xuICBpc09wZW4gPSBmYWxzZTtcblxuICBjb25zdHJ1Y3RvcihcbiAgICAgIEBJbmplY3QoZm9yd2FyZFJlZigoKSA9PiBOZ2JEcm9wZG93bikpIHB1YmxpYyBkcm9wZG93biwgcHJpdmF0ZSBfZWxlbWVudFJlZjogRWxlbWVudFJlZjxIVE1MRWxlbWVudD4sXG4gICAgICBwcml2YXRlIF9yZW5kZXJlcjogUmVuZGVyZXIyKSB7fVxuXG4gIGlzRXZlbnRGcm9tKCRldmVudCkgeyByZXR1cm4gdGhpcy5fZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50LmNvbnRhaW5zKCRldmVudC50YXJnZXQpOyB9XG5cbiAgcG9zaXRpb24odHJpZ2dlckVsLCBwbGFjZW1lbnQpIHtcbiAgICB0aGlzLmFwcGx5UGxhY2VtZW50KHBvc2l0aW9uRWxlbWVudHModHJpZ2dlckVsLCB0aGlzLl9lbGVtZW50UmVmLm5hdGl2ZUVsZW1lbnQsIHBsYWNlbWVudCkpO1xuICB9XG5cbiAgYXBwbHlQbGFjZW1lbnQoX3BsYWNlbWVudDogUGxhY2VtZW50KSB7XG4gICAgLy8gcmVtb3ZlIHRoZSBjdXJyZW50IHBsYWNlbWVudCBjbGFzc2VzXG4gICAgdGhpcy5fcmVuZGVyZXIucmVtb3ZlQ2xhc3ModGhpcy5fZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50LnBhcmVudE5vZGUsICdkcm9wdXAnKTtcbiAgICB0aGlzLl9yZW5kZXJlci5yZW1vdmVDbGFzcyh0aGlzLl9lbGVtZW50UmVmLm5hdGl2ZUVsZW1lbnQucGFyZW50Tm9kZSwgJ2Ryb3Bkb3duJyk7XG4gICAgdGhpcy5wbGFjZW1lbnQgPSBfcGxhY2VtZW50O1xuICAgIC8qKlxuICAgICAqIGFwcGx5IHRoZSBuZXcgcGxhY2VtZW50XG4gICAgICogaW4gY2FzZSBvZiB0b3AgdXNlIHVwLWFycm93IG9yIGRvd24tYXJyb3cgb3RoZXJ3aXNlXG4gICAgICovXG4gICAgaWYgKF9wbGFjZW1lbnQuc2VhcmNoKCdedG9wJykgIT09IC0xKSB7XG4gICAgICB0aGlzLl9yZW5kZXJlci5hZGRDbGFzcyh0aGlzLl9lbGVtZW50UmVmLm5hdGl2ZUVsZW1lbnQucGFyZW50Tm9kZSwgJ2Ryb3B1cCcpO1xuICAgIH0gZWxzZSB7XG4gICAgICB0aGlzLl9yZW5kZXJlci5hZGRDbGFzcyh0aGlzLl9lbGVtZW50UmVmLm5hdGl2ZUVsZW1lbnQucGFyZW50Tm9kZSwgJ2Ryb3Bkb3duJyk7XG4gICAgfVxuICB9XG59XG5cbi8qKlxuICogTWFya3MgYW4gZWxlbWVudCB0byB3aGljaCBkcm9wZG93biBtZW51IHdpbGwgYmUgYW5jaG9yZWQuIFRoaXMgaXMgYSBzaW1wbGUgdmVyc2lvblxuICogb2YgdGhlIE5nYkRyb3Bkb3duVG9nZ2xlIGRpcmVjdGl2ZS4gSXQgcGxheXMgdGhlIHNhbWUgcm9sZSBhcyBOZ2JEcm9wZG93blRvZ2dsZSBidXRcbiAqIGRvZXNuJ3QgbGlzdGVuIHRvIGNsaWNrIGV2ZW50cyB0byB0b2dnbGUgZHJvcGRvd24gbWVudSB0aHVzIGVuYWJsaW5nIHN1cHBvcnQgZm9yXG4gKiBldmVudHMgb3RoZXIgdGhhbiBjbGljay5cbiAqXG4gKiBAc2luY2UgMS4xLjBcbiAqL1xuQERpcmVjdGl2ZSh7XG4gIHNlbGVjdG9yOiAnW25nYkRyb3Bkb3duQW5jaG9yXScsXG4gIGhvc3Q6IHsnY2xhc3MnOiAnZHJvcGRvd24tdG9nZ2xlJywgJ2FyaWEtaGFzcG9wdXAnOiAndHJ1ZScsICdbYXR0ci5hcmlhLWV4cGFuZGVkXSc6ICdkcm9wZG93bi5pc09wZW4oKSd9XG59KVxuZXhwb3J0IGNsYXNzIE5nYkRyb3Bkb3duQW5jaG9yIHtcbiAgYW5jaG9yRWw7XG5cbiAgY29uc3RydWN0b3IoQEluamVjdChmb3J3YXJkUmVmKCgpID0+IE5nYkRyb3Bkb3duKSkgcHVibGljIGRyb3Bkb3duLCBwcml2YXRlIF9lbGVtZW50UmVmOiBFbGVtZW50UmVmPEhUTUxFbGVtZW50Pikge1xuICAgIHRoaXMuYW5jaG9yRWwgPSBfZWxlbWVudFJlZi5uYXRpdmVFbGVtZW50O1xuICB9XG5cbiAgaXNFdmVudEZyb20oJGV2ZW50KSB7IHJldHVybiB0aGlzLl9lbGVtZW50UmVmLm5hdGl2ZUVsZW1lbnQuY29udGFpbnMoJGV2ZW50LnRhcmdldCk7IH1cbn1cblxuLyoqXG4gKiBBbGxvd3MgdGhlIGRyb3Bkb3duIHRvIGJlIHRvZ2dsZWQgdmlhIGNsaWNrLiBUaGlzIGRpcmVjdGl2ZSBpcyBvcHRpb25hbDogeW91IGNhbiB1c2UgTmdiRHJvcGRvd25BbmNob3IgYXMgYW5cbiAqIGFsdGVybmF0aXZlLlxuICovXG5ARGlyZWN0aXZlKHtcbiAgc2VsZWN0b3I6ICdbbmdiRHJvcGRvd25Ub2dnbGVdJyxcbiAgaG9zdDoge1xuICAgICdjbGFzcyc6ICdkcm9wZG93bi10b2dnbGUnLFxuICAgICdhcmlhLWhhc3BvcHVwJzogJ3RydWUnLFxuICAgICdbYXR0ci5hcmlhLWV4cGFuZGVkXSc6ICdkcm9wZG93bi5pc09wZW4oKScsXG4gICAgJyhjbGljayknOiAndG9nZ2xlT3BlbigpJ1xuICB9LFxuICBwcm92aWRlcnM6IFt7cHJvdmlkZTogTmdiRHJvcGRvd25BbmNob3IsIHVzZUV4aXN0aW5nOiBmb3J3YXJkUmVmKCgpID0+IE5nYkRyb3Bkb3duVG9nZ2xlKX1dXG59KVxuZXhwb3J0IGNsYXNzIE5nYkRyb3Bkb3duVG9nZ2xlIGV4dGVuZHMgTmdiRHJvcGRvd25BbmNob3Ige1xuICBjb25zdHJ1Y3RvcihASW5qZWN0KGZvcndhcmRSZWYoKCkgPT4gTmdiRHJvcGRvd24pKSBkcm9wZG93biwgZWxlbWVudFJlZjogRWxlbWVudFJlZjxIVE1MRWxlbWVudD4pIHtcbiAgICBzdXBlcihkcm9wZG93biwgZWxlbWVudFJlZik7XG4gIH1cblxuICB0b2dnbGVPcGVuKCkgeyB0aGlzLmRyb3Bkb3duLnRvZ2dsZSgpOyB9XG59XG5cbi8qKlxuICogVHJhbnNmb3JtcyBhIG5vZGUgaW50byBhIGRyb3Bkb3duLlxuICovXG5ARGlyZWN0aXZlKHtzZWxlY3RvcjogJ1tuZ2JEcm9wZG93bl0nLCBleHBvcnRBczogJ25nYkRyb3Bkb3duJywgaG9zdDogeydbY2xhc3Muc2hvd10nOiAnaXNPcGVuKCknfX0pXG5leHBvcnQgY2xhc3MgTmdiRHJvcGRvd24gaW1wbGVtZW50cyBPbkluaXQsIE9uRGVzdHJveSB7XG4gIHByaXZhdGUgX2Nsb3NlZCQgPSBuZXcgU3ViamVjdDx2b2lkPigpO1xuICBwcml2YXRlIF96b25lU3Vic2NyaXB0aW9uOiBTdWJzY3JpcHRpb247XG5cbiAgQENvbnRlbnRDaGlsZChOZ2JEcm9wZG93bk1lbnUpIHByaXZhdGUgX21lbnU6IE5nYkRyb3Bkb3duTWVudTtcblxuICBAQ29udGVudENoaWxkKE5nYkRyb3Bkb3duQW5jaG9yKSBwcml2YXRlIF9hbmNob3I6IE5nYkRyb3Bkb3duQW5jaG9yO1xuXG4gIC8qKlxuICAgKiBJbmRpY2F0ZXMgdGhhdCBkcm9wZG93biBzaG91bGQgYmUgY2xvc2VkIHdoZW4gc2VsZWN0aW5nIG9uZSBvZiBkcm9wZG93biBpdGVtcyAoY2xpY2spIG9yIHByZXNzaW5nIEVTQy5cbiAgICogV2hlbiBpdCBpcyB0cnVlIChkZWZhdWx0KSBkcm9wZG93bnMgYXJlIGF1dG9tYXRpY2FsbHkgY2xvc2VkIG9uIGJvdGggb3V0c2lkZSBhbmQgaW5zaWRlIChtZW51KSBjbGlja3MuXG4gICAqIFdoZW4gaXQgaXMgZmFsc2UgZHJvcGRvd25zIGFyZSBuZXZlciBhdXRvbWF0aWNhbGx5IGNsb3NlZC5cbiAgICogV2hlbiBpdCBpcyAnb3V0c2lkZScgZHJvcGRvd25zIGFyZSBhdXRvbWF0aWNhbGx5IGNsb3NlZCBvbiBvdXRzaWRlIGNsaWNrcyBidXQgbm90IG9uIG1lbnUgY2xpY2tzLlxuICAgKiBXaGVuIGl0IGlzICdpbnNpZGUnIGRyb3Bkb3ducyBhcmUgYXV0b21hdGljYWxseSBvbiBtZW51IGNsaWNrcyBidXQgbm90IG9uIG91dHNpZGUgY2xpY2tzLlxuICAgKi9cbiAgQElucHV0KCkgYXV0b0Nsb3NlOiBib29sZWFuIHwgJ291dHNpZGUnIHwgJ2luc2lkZSc7XG5cbiAgLyoqXG4gICAqICBEZWZpbmVzIHdoZXRoZXIgb3Igbm90IHRoZSBkcm9wZG93bi1tZW51IGlzIG9wZW4gaW5pdGlhbGx5LlxuICAgKi9cbiAgQElucHV0KCdvcGVuJykgX29wZW4gPSBmYWxzZTtcblxuICAvKipcbiAgICogUGxhY2VtZW50IG9mIGEgcG9wb3ZlciBhY2NlcHRzOlxuICAgKiAgICBcInRvcFwiLCBcInRvcC1sZWZ0XCIsIFwidG9wLXJpZ2h0XCIsIFwiYm90dG9tXCIsIFwiYm90dG9tLWxlZnRcIiwgXCJib3R0b20tcmlnaHRcIixcbiAgICogICAgXCJsZWZ0XCIsIFwibGVmdC10b3BcIiwgXCJsZWZ0LWJvdHRvbVwiLCBcInJpZ2h0XCIsIFwicmlnaHQtdG9wXCIsIFwicmlnaHQtYm90dG9tXCJcbiAgICogYW5kIGFycmF5IG9mIGFib3ZlIHZhbHVlcy5cbiAgICovXG4gIEBJbnB1dCgpIHBsYWNlbWVudDogUGxhY2VtZW50QXJyYXk7XG5cbiAgLyoqXG4gICAqICBBbiBldmVudCBmaXJlZCB3aGVuIHRoZSBkcm9wZG93biBpcyBvcGVuZWQgb3IgY2xvc2VkLlxuICAgKiAgRXZlbnQncyBwYXlsb2FkIGVxdWFscyB3aGV0aGVyIGRyb3Bkb3duIGlzIG9wZW4uXG4gICAqL1xuICBAT3V0cHV0KCkgb3BlbkNoYW5nZSA9IG5ldyBFdmVudEVtaXR0ZXIoKTtcblxuICBjb25zdHJ1Y3RvcihcbiAgICAgIHByaXZhdGUgX2NoYW5nZURldGVjdG9yOiBDaGFuZ2VEZXRlY3RvclJlZiwgY29uZmlnOiBOZ2JEcm9wZG93bkNvbmZpZywgQEluamVjdChET0NVTUVOVCkgcHJpdmF0ZSBfZG9jdW1lbnQ6IGFueSxcbiAgICAgIHByaXZhdGUgX25nWm9uZTogTmdab25lKSB7XG4gICAgdGhpcy5wbGFjZW1lbnQgPSBjb25maWcucGxhY2VtZW50O1xuICAgIHRoaXMuYXV0b0Nsb3NlID0gY29uZmlnLmF1dG9DbG9zZTtcbiAgICB0aGlzLl96b25lU3Vic2NyaXB0aW9uID0gX25nWm9uZS5vblN0YWJsZS5zdWJzY3JpYmUoKCkgPT4geyB0aGlzLl9wb3NpdGlvbk1lbnUoKTsgfSk7XG4gIH1cblxuICBuZ09uSW5pdCgpIHtcbiAgICBpZiAodGhpcy5fbWVudSkge1xuICAgICAgdGhpcy5fbWVudS5hcHBseVBsYWNlbWVudChBcnJheS5pc0FycmF5KHRoaXMucGxhY2VtZW50KSA/ICh0aGlzLnBsYWNlbWVudFswXSkgOiB0aGlzLnBsYWNlbWVudCBhcyBQbGFjZW1lbnQpO1xuICAgIH1cblxuICAgIGlmICh0aGlzLl9vcGVuKSB7XG4gICAgICB0aGlzLl9zZXRDbG9zZUhhbmRsZXJzKCk7XG4gICAgfVxuICB9XG5cbiAgLyoqXG4gICAqIENoZWNrcyBpZiB0aGUgZHJvcGRvd24gbWVudSBpcyBvcGVuIG9yIG5vdC5cbiAgICovXG4gIGlzT3BlbigpOiBib29sZWFuIHsgcmV0dXJuIHRoaXMuX29wZW47IH1cblxuICAvKipcbiAgICogT3BlbnMgdGhlIGRyb3Bkb3duIG1lbnUgb2YgYSBnaXZlbiBuYXZiYXIgb3IgdGFiYmVkIG5hdmlnYXRpb24uXG4gICAqL1xuICBvcGVuKCk6IHZvaWQge1xuICAgIGlmICghdGhpcy5fb3Blbikge1xuICAgICAgdGhpcy5fb3BlbiA9IHRydWU7XG4gICAgICB0aGlzLl9wb3NpdGlvbk1lbnUoKTtcbiAgICAgIHRoaXMub3BlbkNoYW5nZS5lbWl0KHRydWUpO1xuICAgICAgdGhpcy5fc2V0Q2xvc2VIYW5kbGVycygpO1xuICAgIH1cbiAgfVxuXG4gIHByaXZhdGUgX3NldENsb3NlSGFuZGxlcnMoKSB7XG4gICAgaWYgKHRoaXMuYXV0b0Nsb3NlKSB7XG4gICAgICB0aGlzLl9uZ1pvbmUucnVuT3V0c2lkZUFuZ3VsYXIoKCkgPT4ge1xuICAgICAgICBjb25zdCBlc2NhcGVzJCA9IGZyb21FdmVudDxLZXlib2FyZEV2ZW50Pih0aGlzLl9kb2N1bWVudCwgJ2tleXVwJylcbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgLnBpcGUoXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICB0YWtlVW50aWwodGhpcy5fY2xvc2VkJCksXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAvLyB0c2xpbnQ6ZGlzYWJsZS1uZXh0LWxpbmU6ZGVwcmVjYXRpb25cbiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIGZpbHRlcihldmVudCA9PiBldmVudC53aGljaCA9PT0gS2V5LkVzY2FwZSkpO1xuXG4gICAgICAgIGNvbnN0IGNsaWNrcyQgPSBmcm9tRXZlbnQ8TW91c2VFdmVudD4odGhpcy5fZG9jdW1lbnQsICdjbGljaycpXG4gICAgICAgICAgICAgICAgICAgICAgICAgICAgLnBpcGUodGFrZVVudGlsKHRoaXMuX2Nsb3NlZCQpLCBmaWx0ZXIoZXZlbnQgPT4gdGhpcy5fc2hvdWxkQ2xvc2VGcm9tQ2xpY2soZXZlbnQpKSk7XG5cbiAgICAgICAgcmFjZTxFdmVudD4oW2VzY2FwZXMkLCBjbGlja3MkXSkucGlwZSh0YWtlVW50aWwodGhpcy5fY2xvc2VkJCkpLnN1YnNjcmliZSgoKSA9PiB0aGlzLl9uZ1pvbmUucnVuKCgpID0+IHtcbiAgICAgICAgICB0aGlzLmNsb3NlKCk7XG4gICAgICAgICAgdGhpcy5fY2hhbmdlRGV0ZWN0b3IubWFya0ZvckNoZWNrKCk7XG4gICAgICAgIH0pKTtcbiAgICAgIH0pO1xuICAgIH1cbiAgfVxuXG4gIC8qKlxuICAgKiBDbG9zZXMgdGhlIGRyb3Bkb3duIG1lbnUgb2YgYSBnaXZlbiBuYXZiYXIgb3IgdGFiYmVkIG5hdmlnYXRpb24uXG4gICAqL1xuICBjbG9zZSgpOiB2b2lkIHtcbiAgICBpZiAodGhpcy5fb3Blbikge1xuICAgICAgdGhpcy5fb3BlbiA9IGZhbHNlO1xuICAgICAgdGhpcy5fY2xvc2VkJC5uZXh0KCk7XG4gICAgICB0aGlzLm9wZW5DaGFuZ2UuZW1pdChmYWxzZSk7XG4gICAgfVxuICB9XG5cbiAgLyoqXG4gICAqIFRvZ2dsZXMgdGhlIGRyb3Bkb3duIG1lbnUgb2YgYSBnaXZlbiBuYXZiYXIgb3IgdGFiYmVkIG5hdmlnYXRpb24uXG4gICAqL1xuICB0b2dnbGUoKTogdm9pZCB7XG4gICAgaWYgKHRoaXMuaXNPcGVuKCkpIHtcbiAgICAgIHRoaXMuY2xvc2UoKTtcbiAgICB9IGVsc2Uge1xuICAgICAgdGhpcy5vcGVuKCk7XG4gICAgfVxuICB9XG5cbiAgcHJpdmF0ZSBfc2hvdWxkQ2xvc2VGcm9tQ2xpY2soZXZlbnQ6IE1vdXNlRXZlbnQpIHtcbiAgICBpZiAoZXZlbnQuYnV0dG9uICE9PSAyICYmICF0aGlzLl9pc0V2ZW50RnJvbVRvZ2dsZShldmVudCkpIHtcbiAgICAgIGlmICh0aGlzLmF1dG9DbG9zZSA9PT0gdHJ1ZSkge1xuICAgICAgICByZXR1cm4gdHJ1ZTtcbiAgICAgIH0gZWxzZSBpZiAodGhpcy5hdXRvQ2xvc2UgPT09ICdpbnNpZGUnICYmIHRoaXMuX2lzRXZlbnRGcm9tTWVudShldmVudCkpIHtcbiAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgICB9IGVsc2UgaWYgKHRoaXMuYXV0b0Nsb3NlID09PSAnb3V0c2lkZScgJiYgIXRoaXMuX2lzRXZlbnRGcm9tTWVudShldmVudCkpIHtcbiAgICAgICAgcmV0dXJuIHRydWU7XG4gICAgICB9XG4gICAgfVxuICAgIHJldHVybiBmYWxzZTtcbiAgfVxuXG4gIG5nT25EZXN0cm95KCkge1xuICAgIHRoaXMuX2Nsb3NlZCQubmV4dCgpO1xuICAgIHRoaXMuX3pvbmVTdWJzY3JpcHRpb24udW5zdWJzY3JpYmUoKTtcbiAgfVxuXG4gIHByaXZhdGUgX2lzRXZlbnRGcm9tVG9nZ2xlKCRldmVudCkgeyByZXR1cm4gdGhpcy5fYW5jaG9yLmlzRXZlbnRGcm9tKCRldmVudCk7IH1cblxuICBwcml2YXRlIF9pc0V2ZW50RnJvbU1lbnUoJGV2ZW50KSB7IHJldHVybiB0aGlzLl9tZW51ID8gdGhpcy5fbWVudS5pc0V2ZW50RnJvbSgkZXZlbnQpIDogZmFsc2U7IH1cblxuICBwcml2YXRlIF9wb3NpdGlvbk1lbnUoKSB7XG4gICAgaWYgKHRoaXMuaXNPcGVuKCkgJiYgdGhpcy5fbWVudSkge1xuICAgICAgdGhpcy5fbWVudS5wb3NpdGlvbih0aGlzLl9hbmNob3IuYW5jaG9yRWwsIHRoaXMucGxhY2VtZW50KTtcbiAgICB9XG4gIH1cbn1cbiJdfQ==