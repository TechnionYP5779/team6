/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import { DOCUMENT } from '@angular/common';
import { Component, ElementRef, EventEmitter, Inject, Input, Output } from '@angular/core';
import { getFocusableBoundaryElements } from '../util/focus-trap';
import { ModalDismissReasons } from './modal-dismiss-reasons';
var NgbModalWindow = /** @class */ (function () {
    function NgbModalWindow(_document, _elRef) {
        this._document = _document;
        this._elRef = _elRef;
        this.backdrop = true;
        this.keyboard = true;
        this.dismissEvent = new EventEmitter();
    }
    /**
     * @param {?} $event
     * @return {?}
     */
    NgbModalWindow.prototype.backdropClick = /**
     * @param {?} $event
     * @return {?}
     */
    function ($event) {
        if (this.backdrop === true && this._elRef.nativeElement === $event.target) {
            this.dismiss(ModalDismissReasons.BACKDROP_CLICK);
        }
    };
    /**
     * @param {?} $event
     * @return {?}
     */
    NgbModalWindow.prototype.escKey = /**
     * @param {?} $event
     * @return {?}
     */
    function ($event) {
        if (this.keyboard && !$event.defaultPrevented) {
            this.dismiss(ModalDismissReasons.ESC);
        }
    };
    /**
     * @param {?} reason
     * @return {?}
     */
    NgbModalWindow.prototype.dismiss = /**
     * @param {?} reason
     * @return {?}
     */
    function (reason) { this.dismissEvent.emit(reason); };
    /**
     * @return {?}
     */
    NgbModalWindow.prototype.ngOnInit = /**
     * @return {?}
     */
    function () { this._elWithFocus = this._document.activeElement; };
    /**
     * @return {?}
     */
    NgbModalWindow.prototype.ngAfterViewInit = /**
     * @return {?}
     */
    function () {
        if (!this._elRef.nativeElement.contains(document.activeElement)) {
            /** @type {?} */
            var autoFocusable = (/** @type {?} */ (this._elRef.nativeElement.querySelector("[ngbAutofocus]")));
            /** @type {?} */
            var firstFocusable = getFocusableBoundaryElements(this._elRef.nativeElement)[0];
            /** @type {?} */
            var elementToFocus = autoFocusable || firstFocusable || this._elRef.nativeElement;
            elementToFocus.focus();
        }
    };
    /**
     * @return {?}
     */
    NgbModalWindow.prototype.ngOnDestroy = /**
     * @return {?}
     */
    function () {
        /** @type {?} */
        var body = this._document.body;
        /** @type {?} */
        var elWithFocus = this._elWithFocus;
        /** @type {?} */
        var elementToFocus;
        if (elWithFocus && elWithFocus['focus'] && body.contains(elWithFocus)) {
            elementToFocus = elWithFocus;
        }
        else {
            elementToFocus = body;
        }
        elementToFocus.focus();
        this._elWithFocus = null;
    };
    NgbModalWindow.decorators = [
        { type: Component, args: [{
                    selector: 'ngb-modal-window',
                    host: {
                        '[class]': '"modal fade show d-block" + (windowClass ? " " + windowClass : "")',
                        'role': 'dialog',
                        'tabindex': '-1',
                        '(keyup.esc)': 'escKey($event)',
                        '(click)': 'backdropClick($event)',
                        '[attr.aria-labelledby]': 'ariaLabelledBy',
                    },
                    template: "\n    <div [class]=\"'modal-dialog' + (size ? ' modal-' + size : '') + (centered ? ' modal-dialog-centered' : '')\" role=\"document\">\n        <div class=\"modal-content\"><ng-content></ng-content></div>\n    </div>\n    "
                }] }
    ];
    /** @nocollapse */
    NgbModalWindow.ctorParameters = function () { return [
        { type: undefined, decorators: [{ type: Inject, args: [DOCUMENT,] }] },
        { type: ElementRef }
    ]; };
    NgbModalWindow.propDecorators = {
        ariaLabelledBy: [{ type: Input }],
        backdrop: [{ type: Input }],
        centered: [{ type: Input }],
        keyboard: [{ type: Input }],
        size: [{ type: Input }],
        windowClass: [{ type: Input }],
        dismissEvent: [{ type: Output, args: ['dismiss',] }]
    };
    return NgbModalWindow;
}());
export { NgbModalWindow };
if (false) {
    /** @type {?} */
    NgbModalWindow.prototype._elWithFocus;
    /** @type {?} */
    NgbModalWindow.prototype.ariaLabelledBy;
    /** @type {?} */
    NgbModalWindow.prototype.backdrop;
    /** @type {?} */
    NgbModalWindow.prototype.centered;
    /** @type {?} */
    NgbModalWindow.prototype.keyboard;
    /** @type {?} */
    NgbModalWindow.prototype.size;
    /** @type {?} */
    NgbModalWindow.prototype.windowClass;
    /** @type {?} */
    NgbModalWindow.prototype.dismissEvent;
    /** @type {?} */
    NgbModalWindow.prototype._document;
    /** @type {?} */
    NgbModalWindow.prototype._elRef;
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibW9kYWwtd2luZG93LmpzIiwic291cmNlUm9vdCI6Im5nOi8vQG5nLWJvb3RzdHJhcC9uZy1ib290c3RyYXAvIiwic291cmNlcyI6WyJtb2RhbC9tb2RhbC13aW5kb3cudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7OztBQUFBLE9BQU8sRUFBQyxRQUFRLEVBQUMsTUFBTSxpQkFBaUIsQ0FBQztBQUN6QyxPQUFPLEVBRUwsU0FBUyxFQUNULFVBQVUsRUFDVixZQUFZLEVBQ1osTUFBTSxFQUNOLEtBQUssRUFHTCxNQUFNLEVBQ1AsTUFBTSxlQUFlLENBQUM7QUFFdkIsT0FBTyxFQUFDLDRCQUE0QixFQUFDLE1BQU0sb0JBQW9CLENBQUM7QUFDaEUsT0FBTyxFQUFDLG1CQUFtQixFQUFDLE1BQU0seUJBQXlCLENBQUM7QUFFNUQ7SUE2QkUsd0JBQXNDLFNBQWMsRUFBVSxNQUErQjtRQUF2RCxjQUFTLEdBQVQsU0FBUyxDQUFLO1FBQVUsV0FBTSxHQUFOLE1BQU0sQ0FBeUI7UUFScEYsYUFBUSxHQUFxQixJQUFJLENBQUM7UUFFbEMsYUFBUSxHQUFHLElBQUksQ0FBQztRQUlOLGlCQUFZLEdBQUcsSUFBSSxZQUFZLEVBQUUsQ0FBQztJQUUyQyxDQUFDOzs7OztJQUVqRyxzQ0FBYTs7OztJQUFiLFVBQWMsTUFBTTtRQUNsQixJQUFJLElBQUksQ0FBQyxRQUFRLEtBQUssSUFBSSxJQUFJLElBQUksQ0FBQyxNQUFNLENBQUMsYUFBYSxLQUFLLE1BQU0sQ0FBQyxNQUFNLEVBQUU7WUFDekUsSUFBSSxDQUFDLE9BQU8sQ0FBQyxtQkFBbUIsQ0FBQyxjQUFjLENBQUMsQ0FBQztTQUNsRDtJQUNILENBQUM7Ozs7O0lBRUQsK0JBQU07Ozs7SUFBTixVQUFPLE1BQU07UUFDWCxJQUFJLElBQUksQ0FBQyxRQUFRLElBQUksQ0FBQyxNQUFNLENBQUMsZ0JBQWdCLEVBQUU7WUFDN0MsSUFBSSxDQUFDLE9BQU8sQ0FBQyxtQkFBbUIsQ0FBQyxHQUFHLENBQUMsQ0FBQztTQUN2QztJQUNILENBQUM7Ozs7O0lBRUQsZ0NBQU87Ozs7SUFBUCxVQUFRLE1BQU0sSUFBVSxJQUFJLENBQUMsWUFBWSxDQUFDLElBQUksQ0FBQyxNQUFNLENBQUMsQ0FBQyxDQUFDLENBQUM7Ozs7SUFFekQsaUNBQVE7OztJQUFSLGNBQWEsSUFBSSxDQUFDLFlBQVksR0FBRyxJQUFJLENBQUMsU0FBUyxDQUFDLGFBQWEsQ0FBQyxDQUFDLENBQUM7Ozs7SUFFaEUsd0NBQWU7OztJQUFmO1FBQ0UsSUFBSSxDQUFDLElBQUksQ0FBQyxNQUFNLENBQUMsYUFBYSxDQUFDLFFBQVEsQ0FBQyxRQUFRLENBQUMsYUFBYSxDQUFDLEVBQUU7O2dCQUN6RCxhQUFhLEdBQUcsbUJBQUEsSUFBSSxDQUFDLE1BQU0sQ0FBQyxhQUFhLENBQUMsYUFBYSxDQUFDLGdCQUFnQixDQUFDLEVBQWU7O2dCQUN4RixjQUFjLEdBQUcsNEJBQTRCLENBQUMsSUFBSSxDQUFDLE1BQU0sQ0FBQyxhQUFhLENBQUMsQ0FBQyxDQUFDLENBQUM7O2dCQUUzRSxjQUFjLEdBQUcsYUFBYSxJQUFJLGNBQWMsSUFBSSxJQUFJLENBQUMsTUFBTSxDQUFDLGFBQWE7WUFDbkYsY0FBYyxDQUFDLEtBQUssRUFBRSxDQUFDO1NBQ3hCO0lBQ0gsQ0FBQzs7OztJQUVELG9DQUFXOzs7SUFBWDs7WUFDUSxJQUFJLEdBQUcsSUFBSSxDQUFDLFNBQVMsQ0FBQyxJQUFJOztZQUMxQixXQUFXLEdBQUcsSUFBSSxDQUFDLFlBQVk7O1lBRWpDLGNBQWM7UUFDbEIsSUFBSSxXQUFXLElBQUksV0FBVyxDQUFDLE9BQU8sQ0FBQyxJQUFJLElBQUksQ0FBQyxRQUFRLENBQUMsV0FBVyxDQUFDLEVBQUU7WUFDckUsY0FBYyxHQUFHLFdBQVcsQ0FBQztTQUM5QjthQUFNO1lBQ0wsY0FBYyxHQUFHLElBQUksQ0FBQztTQUN2QjtRQUNELGNBQWMsQ0FBQyxLQUFLLEVBQUUsQ0FBQztRQUN2QixJQUFJLENBQUMsWUFBWSxHQUFHLElBQUksQ0FBQztJQUMzQixDQUFDOztnQkFyRUYsU0FBUyxTQUFDO29CQUNULFFBQVEsRUFBRSxrQkFBa0I7b0JBQzVCLElBQUksRUFBRTt3QkFDSixTQUFTLEVBQUUsb0VBQW9FO3dCQUMvRSxNQUFNLEVBQUUsUUFBUTt3QkFDaEIsVUFBVSxFQUFFLElBQUk7d0JBQ2hCLGFBQWEsRUFBRSxnQkFBZ0I7d0JBQy9CLFNBQVMsRUFBRSx1QkFBdUI7d0JBQ2xDLHdCQUF3QixFQUFFLGdCQUFnQjtxQkFDM0M7b0JBQ0QsUUFBUSxFQUFFLGdPQUlQO2lCQUNKOzs7O2dEQWNjLE1BQU0sU0FBQyxRQUFRO2dCQXpDNUIsVUFBVTs7O2lDQWdDVCxLQUFLOzJCQUNMLEtBQUs7MkJBQ0wsS0FBSzsyQkFDTCxLQUFLO3VCQUNMLEtBQUs7OEJBQ0wsS0FBSzsrQkFFTCxNQUFNLFNBQUMsU0FBUzs7SUEyQ25CLHFCQUFDO0NBQUEsQUF0RUQsSUFzRUM7U0F0RFksY0FBYzs7O0lBRXpCLHNDQUE4Qjs7SUFFOUIsd0NBQWdDOztJQUNoQyxrQ0FBMkM7O0lBQzNDLGtDQUEwQjs7SUFDMUIsa0NBQXlCOztJQUN6Qiw4QkFBc0I7O0lBQ3RCLHFDQUE2Qjs7SUFFN0Isc0NBQXFEOztJQUV6QyxtQ0FBd0M7O0lBQUUsZ0NBQXVDIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtET0NVTUVOVH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcbmltcG9ydCB7XG4gIEFmdGVyVmlld0luaXQsXG4gIENvbXBvbmVudCxcbiAgRWxlbWVudFJlZixcbiAgRXZlbnRFbWl0dGVyLFxuICBJbmplY3QsXG4gIElucHV0LFxuICBPbkRlc3Ryb3ksXG4gIE9uSW5pdCxcbiAgT3V0cHV0XG59IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuXG5pbXBvcnQge2dldEZvY3VzYWJsZUJvdW5kYXJ5RWxlbWVudHN9IGZyb20gJy4uL3V0aWwvZm9jdXMtdHJhcCc7XG5pbXBvcnQge01vZGFsRGlzbWlzc1JlYXNvbnN9IGZyb20gJy4vbW9kYWwtZGlzbWlzcy1yZWFzb25zJztcblxuQENvbXBvbmVudCh7XG4gIHNlbGVjdG9yOiAnbmdiLW1vZGFsLXdpbmRvdycsXG4gIGhvc3Q6IHtcbiAgICAnW2NsYXNzXSc6ICdcIm1vZGFsIGZhZGUgc2hvdyBkLWJsb2NrXCIgKyAod2luZG93Q2xhc3MgPyBcIiBcIiArIHdpbmRvd0NsYXNzIDogXCJcIiknLFxuICAgICdyb2xlJzogJ2RpYWxvZycsXG4gICAgJ3RhYmluZGV4JzogJy0xJyxcbiAgICAnKGtleXVwLmVzYyknOiAnZXNjS2V5KCRldmVudCknLFxuICAgICcoY2xpY2spJzogJ2JhY2tkcm9wQ2xpY2soJGV2ZW50KScsXG4gICAgJ1thdHRyLmFyaWEtbGFiZWxsZWRieV0nOiAnYXJpYUxhYmVsbGVkQnknLFxuICB9LFxuICB0ZW1wbGF0ZTogYFxuICAgIDxkaXYgW2NsYXNzXT1cIidtb2RhbC1kaWFsb2cnICsgKHNpemUgPyAnIG1vZGFsLScgKyBzaXplIDogJycpICsgKGNlbnRlcmVkID8gJyBtb2RhbC1kaWFsb2ctY2VudGVyZWQnIDogJycpXCIgcm9sZT1cImRvY3VtZW50XCI+XG4gICAgICAgIDxkaXYgY2xhc3M9XCJtb2RhbC1jb250ZW50XCI+PG5nLWNvbnRlbnQ+PC9uZy1jb250ZW50PjwvZGl2PlxuICAgIDwvZGl2PlxuICAgIGBcbn0pXG5leHBvcnQgY2xhc3MgTmdiTW9kYWxXaW5kb3cgaW1wbGVtZW50cyBPbkluaXQsXG4gICAgQWZ0ZXJWaWV3SW5pdCwgT25EZXN0cm95IHtcbiAgcHJpdmF0ZSBfZWxXaXRoRm9jdXM6IEVsZW1lbnQ7ICAvLyBlbGVtZW50IHRoYXQgaXMgZm9jdXNlZCBwcmlvciB0byBtb2RhbCBvcGVuaW5nXG5cbiAgQElucHV0KCkgYXJpYUxhYmVsbGVkQnk6IHN0cmluZztcbiAgQElucHV0KCkgYmFja2Ryb3A6IGJvb2xlYW4gfCBzdHJpbmcgPSB0cnVlO1xuICBASW5wdXQoKSBjZW50ZXJlZDogc3RyaW5nO1xuICBASW5wdXQoKSBrZXlib2FyZCA9IHRydWU7XG4gIEBJbnB1dCgpIHNpemU6IHN0cmluZztcbiAgQElucHV0KCkgd2luZG93Q2xhc3M6IHN0cmluZztcblxuICBAT3V0cHV0KCdkaXNtaXNzJykgZGlzbWlzc0V2ZW50ID0gbmV3IEV2ZW50RW1pdHRlcigpO1xuXG4gIGNvbnN0cnVjdG9yKEBJbmplY3QoRE9DVU1FTlQpIHByaXZhdGUgX2RvY3VtZW50OiBhbnksIHByaXZhdGUgX2VsUmVmOiBFbGVtZW50UmVmPEhUTUxFbGVtZW50Pikge31cblxuICBiYWNrZHJvcENsaWNrKCRldmVudCk6IHZvaWQge1xuICAgIGlmICh0aGlzLmJhY2tkcm9wID09PSB0cnVlICYmIHRoaXMuX2VsUmVmLm5hdGl2ZUVsZW1lbnQgPT09ICRldmVudC50YXJnZXQpIHtcbiAgICAgIHRoaXMuZGlzbWlzcyhNb2RhbERpc21pc3NSZWFzb25zLkJBQ0tEUk9QX0NMSUNLKTtcbiAgICB9XG4gIH1cblxuICBlc2NLZXkoJGV2ZW50KTogdm9pZCB7XG4gICAgaWYgKHRoaXMua2V5Ym9hcmQgJiYgISRldmVudC5kZWZhdWx0UHJldmVudGVkKSB7XG4gICAgICB0aGlzLmRpc21pc3MoTW9kYWxEaXNtaXNzUmVhc29ucy5FU0MpO1xuICAgIH1cbiAgfVxuXG4gIGRpc21pc3MocmVhc29uKTogdm9pZCB7IHRoaXMuZGlzbWlzc0V2ZW50LmVtaXQocmVhc29uKTsgfVxuXG4gIG5nT25Jbml0KCkgeyB0aGlzLl9lbFdpdGhGb2N1cyA9IHRoaXMuX2RvY3VtZW50LmFjdGl2ZUVsZW1lbnQ7IH1cblxuICBuZ0FmdGVyVmlld0luaXQoKSB7XG4gICAgaWYgKCF0aGlzLl9lbFJlZi5uYXRpdmVFbGVtZW50LmNvbnRhaW5zKGRvY3VtZW50LmFjdGl2ZUVsZW1lbnQpKSB7XG4gICAgICBjb25zdCBhdXRvRm9jdXNhYmxlID0gdGhpcy5fZWxSZWYubmF0aXZlRWxlbWVudC5xdWVyeVNlbGVjdG9yKGBbbmdiQXV0b2ZvY3VzXWApIGFzIEhUTUxFbGVtZW50O1xuICAgICAgY29uc3QgZmlyc3RGb2N1c2FibGUgPSBnZXRGb2N1c2FibGVCb3VuZGFyeUVsZW1lbnRzKHRoaXMuX2VsUmVmLm5hdGl2ZUVsZW1lbnQpWzBdO1xuXG4gICAgICBjb25zdCBlbGVtZW50VG9Gb2N1cyA9IGF1dG9Gb2N1c2FibGUgfHwgZmlyc3RGb2N1c2FibGUgfHwgdGhpcy5fZWxSZWYubmF0aXZlRWxlbWVudDtcbiAgICAgIGVsZW1lbnRUb0ZvY3VzLmZvY3VzKCk7XG4gICAgfVxuICB9XG5cbiAgbmdPbkRlc3Ryb3koKSB7XG4gICAgY29uc3QgYm9keSA9IHRoaXMuX2RvY3VtZW50LmJvZHk7XG4gICAgY29uc3QgZWxXaXRoRm9jdXMgPSB0aGlzLl9lbFdpdGhGb2N1cztcblxuICAgIGxldCBlbGVtZW50VG9Gb2N1cztcbiAgICBpZiAoZWxXaXRoRm9jdXMgJiYgZWxXaXRoRm9jdXNbJ2ZvY3VzJ10gJiYgYm9keS5jb250YWlucyhlbFdpdGhGb2N1cykpIHtcbiAgICAgIGVsZW1lbnRUb0ZvY3VzID0gZWxXaXRoRm9jdXM7XG4gICAgfSBlbHNlIHtcbiAgICAgIGVsZW1lbnRUb0ZvY3VzID0gYm9keTtcbiAgICB9XG4gICAgZWxlbWVudFRvRm9jdXMuZm9jdXMoKTtcbiAgICB0aGlzLl9lbFdpdGhGb2N1cyA9IG51bGw7XG4gIH1cbn1cbiJdfQ==