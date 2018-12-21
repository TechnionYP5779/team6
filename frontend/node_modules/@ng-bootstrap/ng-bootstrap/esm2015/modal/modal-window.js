/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import { DOCUMENT } from '@angular/common';
import { Component, ElementRef, EventEmitter, Inject, Input, Output } from '@angular/core';
import { getFocusableBoundaryElements } from '../util/focus-trap';
import { ModalDismissReasons } from './modal-dismiss-reasons';
export class NgbModalWindow {
    /**
     * @param {?} _document
     * @param {?} _elRef
     */
    constructor(_document, _elRef) {
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
    backdropClick($event) {
        if (this.backdrop === true && this._elRef.nativeElement === $event.target) {
            this.dismiss(ModalDismissReasons.BACKDROP_CLICK);
        }
    }
    /**
     * @param {?} $event
     * @return {?}
     */
    escKey($event) {
        if (this.keyboard && !$event.defaultPrevented) {
            this.dismiss(ModalDismissReasons.ESC);
        }
    }
    /**
     * @param {?} reason
     * @return {?}
     */
    dismiss(reason) { this.dismissEvent.emit(reason); }
    /**
     * @return {?}
     */
    ngOnInit() { this._elWithFocus = this._document.activeElement; }
    /**
     * @return {?}
     */
    ngAfterViewInit() {
        if (!this._elRef.nativeElement.contains(document.activeElement)) {
            /** @type {?} */
            const autoFocusable = (/** @type {?} */ (this._elRef.nativeElement.querySelector(`[ngbAutofocus]`)));
            /** @type {?} */
            const firstFocusable = getFocusableBoundaryElements(this._elRef.nativeElement)[0];
            /** @type {?} */
            const elementToFocus = autoFocusable || firstFocusable || this._elRef.nativeElement;
            elementToFocus.focus();
        }
    }
    /**
     * @return {?}
     */
    ngOnDestroy() {
        /** @type {?} */
        const body = this._document.body;
        /** @type {?} */
        const elWithFocus = this._elWithFocus;
        /** @type {?} */
        let elementToFocus;
        if (elWithFocus && elWithFocus['focus'] && body.contains(elWithFocus)) {
            elementToFocus = elWithFocus;
        }
        else {
            elementToFocus = body;
        }
        elementToFocus.focus();
        this._elWithFocus = null;
    }
}
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
                template: `
    <div [class]="'modal-dialog' + (size ? ' modal-' + size : '') + (centered ? ' modal-dialog-centered' : '')" role="document">
        <div class="modal-content"><ng-content></ng-content></div>
    </div>
    `
            }] }
];
/** @nocollapse */
NgbModalWindow.ctorParameters = () => [
    { type: undefined, decorators: [{ type: Inject, args: [DOCUMENT,] }] },
    { type: ElementRef }
];
NgbModalWindow.propDecorators = {
    ariaLabelledBy: [{ type: Input }],
    backdrop: [{ type: Input }],
    centered: [{ type: Input }],
    keyboard: [{ type: Input }],
    size: [{ type: Input }],
    windowClass: [{ type: Input }],
    dismissEvent: [{ type: Output, args: ['dismiss',] }]
};
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
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibW9kYWwtd2luZG93LmpzIiwic291cmNlUm9vdCI6Im5nOi8vQG5nLWJvb3RzdHJhcC9uZy1ib290c3RyYXAvIiwic291cmNlcyI6WyJtb2RhbC9tb2RhbC13aW5kb3cudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7OztBQUFBLE9BQU8sRUFBQyxRQUFRLEVBQUMsTUFBTSxpQkFBaUIsQ0FBQztBQUN6QyxPQUFPLEVBRUwsU0FBUyxFQUNULFVBQVUsRUFDVixZQUFZLEVBQ1osTUFBTSxFQUNOLEtBQUssRUFHTCxNQUFNLEVBQ1AsTUFBTSxlQUFlLENBQUM7QUFFdkIsT0FBTyxFQUFDLDRCQUE0QixFQUFDLE1BQU0sb0JBQW9CLENBQUM7QUFDaEUsT0FBTyxFQUFDLG1CQUFtQixFQUFDLE1BQU0seUJBQXlCLENBQUM7QUFrQjVELE1BQU0sT0FBTyxjQUFjOzs7OztJQWF6QixZQUFzQyxTQUFjLEVBQVUsTUFBK0I7UUFBdkQsY0FBUyxHQUFULFNBQVMsQ0FBSztRQUFVLFdBQU0sR0FBTixNQUFNLENBQXlCO1FBUnBGLGFBQVEsR0FBcUIsSUFBSSxDQUFDO1FBRWxDLGFBQVEsR0FBRyxJQUFJLENBQUM7UUFJTixpQkFBWSxHQUFHLElBQUksWUFBWSxFQUFFLENBQUM7SUFFMkMsQ0FBQzs7Ozs7SUFFakcsYUFBYSxDQUFDLE1BQU07UUFDbEIsSUFBSSxJQUFJLENBQUMsUUFBUSxLQUFLLElBQUksSUFBSSxJQUFJLENBQUMsTUFBTSxDQUFDLGFBQWEsS0FBSyxNQUFNLENBQUMsTUFBTSxFQUFFO1lBQ3pFLElBQUksQ0FBQyxPQUFPLENBQUMsbUJBQW1CLENBQUMsY0FBYyxDQUFDLENBQUM7U0FDbEQ7SUFDSCxDQUFDOzs7OztJQUVELE1BQU0sQ0FBQyxNQUFNO1FBQ1gsSUFBSSxJQUFJLENBQUMsUUFBUSxJQUFJLENBQUMsTUFBTSxDQUFDLGdCQUFnQixFQUFFO1lBQzdDLElBQUksQ0FBQyxPQUFPLENBQUMsbUJBQW1CLENBQUMsR0FBRyxDQUFDLENBQUM7U0FDdkM7SUFDSCxDQUFDOzs7OztJQUVELE9BQU8sQ0FBQyxNQUFNLElBQVUsSUFBSSxDQUFDLFlBQVksQ0FBQyxJQUFJLENBQUMsTUFBTSxDQUFDLENBQUMsQ0FBQyxDQUFDOzs7O0lBRXpELFFBQVEsS0FBSyxJQUFJLENBQUMsWUFBWSxHQUFHLElBQUksQ0FBQyxTQUFTLENBQUMsYUFBYSxDQUFDLENBQUMsQ0FBQzs7OztJQUVoRSxlQUFlO1FBQ2IsSUFBSSxDQUFDLElBQUksQ0FBQyxNQUFNLENBQUMsYUFBYSxDQUFDLFFBQVEsQ0FBQyxRQUFRLENBQUMsYUFBYSxDQUFDLEVBQUU7O2tCQUN6RCxhQUFhLEdBQUcsbUJBQUEsSUFBSSxDQUFDLE1BQU0sQ0FBQyxhQUFhLENBQUMsYUFBYSxDQUFDLGdCQUFnQixDQUFDLEVBQWU7O2tCQUN4RixjQUFjLEdBQUcsNEJBQTRCLENBQUMsSUFBSSxDQUFDLE1BQU0sQ0FBQyxhQUFhLENBQUMsQ0FBQyxDQUFDLENBQUM7O2tCQUUzRSxjQUFjLEdBQUcsYUFBYSxJQUFJLGNBQWMsSUFBSSxJQUFJLENBQUMsTUFBTSxDQUFDLGFBQWE7WUFDbkYsY0FBYyxDQUFDLEtBQUssRUFBRSxDQUFDO1NBQ3hCO0lBQ0gsQ0FBQzs7OztJQUVELFdBQVc7O2NBQ0gsSUFBSSxHQUFHLElBQUksQ0FBQyxTQUFTLENBQUMsSUFBSTs7Y0FDMUIsV0FBVyxHQUFHLElBQUksQ0FBQyxZQUFZOztZQUVqQyxjQUFjO1FBQ2xCLElBQUksV0FBVyxJQUFJLFdBQVcsQ0FBQyxPQUFPLENBQUMsSUFBSSxJQUFJLENBQUMsUUFBUSxDQUFDLFdBQVcsQ0FBQyxFQUFFO1lBQ3JFLGNBQWMsR0FBRyxXQUFXLENBQUM7U0FDOUI7YUFBTTtZQUNMLGNBQWMsR0FBRyxJQUFJLENBQUM7U0FDdkI7UUFDRCxjQUFjLENBQUMsS0FBSyxFQUFFLENBQUM7UUFDdkIsSUFBSSxDQUFDLFlBQVksR0FBRyxJQUFJLENBQUM7SUFDM0IsQ0FBQzs7O1lBckVGLFNBQVMsU0FBQztnQkFDVCxRQUFRLEVBQUUsa0JBQWtCO2dCQUM1QixJQUFJLEVBQUU7b0JBQ0osU0FBUyxFQUFFLG9FQUFvRTtvQkFDL0UsTUFBTSxFQUFFLFFBQVE7b0JBQ2hCLFVBQVUsRUFBRSxJQUFJO29CQUNoQixhQUFhLEVBQUUsZ0JBQWdCO29CQUMvQixTQUFTLEVBQUUsdUJBQXVCO29CQUNsQyx3QkFBd0IsRUFBRSxnQkFBZ0I7aUJBQzNDO2dCQUNELFFBQVEsRUFBRTs7OztLQUlQO2FBQ0o7Ozs7NENBY2MsTUFBTSxTQUFDLFFBQVE7WUF6QzVCLFVBQVU7Ozs2QkFnQ1QsS0FBSzt1QkFDTCxLQUFLO3VCQUNMLEtBQUs7dUJBQ0wsS0FBSzttQkFDTCxLQUFLOzBCQUNMLEtBQUs7MkJBRUwsTUFBTSxTQUFDLFNBQVM7Ozs7SUFUakIsc0NBQThCOztJQUU5Qix3Q0FBZ0M7O0lBQ2hDLGtDQUEyQzs7SUFDM0Msa0NBQTBCOztJQUMxQixrQ0FBeUI7O0lBQ3pCLDhCQUFzQjs7SUFDdEIscUNBQTZCOztJQUU3QixzQ0FBcUQ7O0lBRXpDLG1DQUF3Qzs7SUFBRSxnQ0FBdUMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0RPQ1VNRU5UfSBmcm9tICdAYW5ndWxhci9jb21tb24nO1xuaW1wb3J0IHtcbiAgQWZ0ZXJWaWV3SW5pdCxcbiAgQ29tcG9uZW50LFxuICBFbGVtZW50UmVmLFxuICBFdmVudEVtaXR0ZXIsXG4gIEluamVjdCxcbiAgSW5wdXQsXG4gIE9uRGVzdHJveSxcbiAgT25Jbml0LFxuICBPdXRwdXRcbn0gZnJvbSAnQGFuZ3VsYXIvY29yZSc7XG5cbmltcG9ydCB7Z2V0Rm9jdXNhYmxlQm91bmRhcnlFbGVtZW50c30gZnJvbSAnLi4vdXRpbC9mb2N1cy10cmFwJztcbmltcG9ydCB7TW9kYWxEaXNtaXNzUmVhc29uc30gZnJvbSAnLi9tb2RhbC1kaXNtaXNzLXJlYXNvbnMnO1xuXG5AQ29tcG9uZW50KHtcbiAgc2VsZWN0b3I6ICduZ2ItbW9kYWwtd2luZG93JyxcbiAgaG9zdDoge1xuICAgICdbY2xhc3NdJzogJ1wibW9kYWwgZmFkZSBzaG93IGQtYmxvY2tcIiArICh3aW5kb3dDbGFzcyA/IFwiIFwiICsgd2luZG93Q2xhc3MgOiBcIlwiKScsXG4gICAgJ3JvbGUnOiAnZGlhbG9nJyxcbiAgICAndGFiaW5kZXgnOiAnLTEnLFxuICAgICcoa2V5dXAuZXNjKSc6ICdlc2NLZXkoJGV2ZW50KScsXG4gICAgJyhjbGljayknOiAnYmFja2Ryb3BDbGljaygkZXZlbnQpJyxcbiAgICAnW2F0dHIuYXJpYS1sYWJlbGxlZGJ5XSc6ICdhcmlhTGFiZWxsZWRCeScsXG4gIH0sXG4gIHRlbXBsYXRlOiBgXG4gICAgPGRpdiBbY2xhc3NdPVwiJ21vZGFsLWRpYWxvZycgKyAoc2l6ZSA/ICcgbW9kYWwtJyArIHNpemUgOiAnJykgKyAoY2VudGVyZWQgPyAnIG1vZGFsLWRpYWxvZy1jZW50ZXJlZCcgOiAnJylcIiByb2xlPVwiZG9jdW1lbnRcIj5cbiAgICAgICAgPGRpdiBjbGFzcz1cIm1vZGFsLWNvbnRlbnRcIj48bmctY29udGVudD48L25nLWNvbnRlbnQ+PC9kaXY+XG4gICAgPC9kaXY+XG4gICAgYFxufSlcbmV4cG9ydCBjbGFzcyBOZ2JNb2RhbFdpbmRvdyBpbXBsZW1lbnRzIE9uSW5pdCxcbiAgICBBZnRlclZpZXdJbml0LCBPbkRlc3Ryb3kge1xuICBwcml2YXRlIF9lbFdpdGhGb2N1czogRWxlbWVudDsgIC8vIGVsZW1lbnQgdGhhdCBpcyBmb2N1c2VkIHByaW9yIHRvIG1vZGFsIG9wZW5pbmdcblxuICBASW5wdXQoKSBhcmlhTGFiZWxsZWRCeTogc3RyaW5nO1xuICBASW5wdXQoKSBiYWNrZHJvcDogYm9vbGVhbiB8IHN0cmluZyA9IHRydWU7XG4gIEBJbnB1dCgpIGNlbnRlcmVkOiBzdHJpbmc7XG4gIEBJbnB1dCgpIGtleWJvYXJkID0gdHJ1ZTtcbiAgQElucHV0KCkgc2l6ZTogc3RyaW5nO1xuICBASW5wdXQoKSB3aW5kb3dDbGFzczogc3RyaW5nO1xuXG4gIEBPdXRwdXQoJ2Rpc21pc3MnKSBkaXNtaXNzRXZlbnQgPSBuZXcgRXZlbnRFbWl0dGVyKCk7XG5cbiAgY29uc3RydWN0b3IoQEluamVjdChET0NVTUVOVCkgcHJpdmF0ZSBfZG9jdW1lbnQ6IGFueSwgcHJpdmF0ZSBfZWxSZWY6IEVsZW1lbnRSZWY8SFRNTEVsZW1lbnQ+KSB7fVxuXG4gIGJhY2tkcm9wQ2xpY2soJGV2ZW50KTogdm9pZCB7XG4gICAgaWYgKHRoaXMuYmFja2Ryb3AgPT09IHRydWUgJiYgdGhpcy5fZWxSZWYubmF0aXZlRWxlbWVudCA9PT0gJGV2ZW50LnRhcmdldCkge1xuICAgICAgdGhpcy5kaXNtaXNzKE1vZGFsRGlzbWlzc1JlYXNvbnMuQkFDS0RST1BfQ0xJQ0spO1xuICAgIH1cbiAgfVxuXG4gIGVzY0tleSgkZXZlbnQpOiB2b2lkIHtcbiAgICBpZiAodGhpcy5rZXlib2FyZCAmJiAhJGV2ZW50LmRlZmF1bHRQcmV2ZW50ZWQpIHtcbiAgICAgIHRoaXMuZGlzbWlzcyhNb2RhbERpc21pc3NSZWFzb25zLkVTQyk7XG4gICAgfVxuICB9XG5cbiAgZGlzbWlzcyhyZWFzb24pOiB2b2lkIHsgdGhpcy5kaXNtaXNzRXZlbnQuZW1pdChyZWFzb24pOyB9XG5cbiAgbmdPbkluaXQoKSB7IHRoaXMuX2VsV2l0aEZvY3VzID0gdGhpcy5fZG9jdW1lbnQuYWN0aXZlRWxlbWVudDsgfVxuXG4gIG5nQWZ0ZXJWaWV3SW5pdCgpIHtcbiAgICBpZiAoIXRoaXMuX2VsUmVmLm5hdGl2ZUVsZW1lbnQuY29udGFpbnMoZG9jdW1lbnQuYWN0aXZlRWxlbWVudCkpIHtcbiAgICAgIGNvbnN0IGF1dG9Gb2N1c2FibGUgPSB0aGlzLl9lbFJlZi5uYXRpdmVFbGVtZW50LnF1ZXJ5U2VsZWN0b3IoYFtuZ2JBdXRvZm9jdXNdYCkgYXMgSFRNTEVsZW1lbnQ7XG4gICAgICBjb25zdCBmaXJzdEZvY3VzYWJsZSA9IGdldEZvY3VzYWJsZUJvdW5kYXJ5RWxlbWVudHModGhpcy5fZWxSZWYubmF0aXZlRWxlbWVudClbMF07XG5cbiAgICAgIGNvbnN0IGVsZW1lbnRUb0ZvY3VzID0gYXV0b0ZvY3VzYWJsZSB8fCBmaXJzdEZvY3VzYWJsZSB8fCB0aGlzLl9lbFJlZi5uYXRpdmVFbGVtZW50O1xuICAgICAgZWxlbWVudFRvRm9jdXMuZm9jdXMoKTtcbiAgICB9XG4gIH1cblxuICBuZ09uRGVzdHJveSgpIHtcbiAgICBjb25zdCBib2R5ID0gdGhpcy5fZG9jdW1lbnQuYm9keTtcbiAgICBjb25zdCBlbFdpdGhGb2N1cyA9IHRoaXMuX2VsV2l0aEZvY3VzO1xuXG4gICAgbGV0IGVsZW1lbnRUb0ZvY3VzO1xuICAgIGlmIChlbFdpdGhGb2N1cyAmJiBlbFdpdGhGb2N1c1snZm9jdXMnXSAmJiBib2R5LmNvbnRhaW5zKGVsV2l0aEZvY3VzKSkge1xuICAgICAgZWxlbWVudFRvRm9jdXMgPSBlbFdpdGhGb2N1cztcbiAgICB9IGVsc2Uge1xuICAgICAgZWxlbWVudFRvRm9jdXMgPSBib2R5O1xuICAgIH1cbiAgICBlbGVtZW50VG9Gb2N1cy5mb2N1cygpO1xuICAgIHRoaXMuX2VsV2l0aEZvY3VzID0gbnVsbDtcbiAgfVxufVxuIl19