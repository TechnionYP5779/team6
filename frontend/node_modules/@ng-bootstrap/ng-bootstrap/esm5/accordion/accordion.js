/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import { Component, ContentChildren, Directive, EventEmitter, Input, Output, QueryList, TemplateRef } from '@angular/core';
import { isString } from '../util/util';
import { NgbAccordionConfig } from './accordion-config';
/** @type {?} */
var nextId = 0;
/**
 * This directive should be used to wrap accordion panel titles that need to contain HTML markup or other directives.
 */
var NgbPanelTitle = /** @class */ (function () {
    function NgbPanelTitle(templateRef) {
        this.templateRef = templateRef;
    }
    NgbPanelTitle.decorators = [
        { type: Directive, args: [{ selector: 'ng-template[ngbPanelTitle]' },] }
    ];
    /** @nocollapse */
    NgbPanelTitle.ctorParameters = function () { return [
        { type: TemplateRef }
    ]; };
    return NgbPanelTitle;
}());
export { NgbPanelTitle };
if (false) {
    /** @type {?} */
    NgbPanelTitle.prototype.templateRef;
}
/**
 * This directive must be used to wrap accordion panel content.
 */
var NgbPanelContent = /** @class */ (function () {
    function NgbPanelContent(templateRef) {
        this.templateRef = templateRef;
    }
    NgbPanelContent.decorators = [
        { type: Directive, args: [{ selector: 'ng-template[ngbPanelContent]' },] }
    ];
    /** @nocollapse */
    NgbPanelContent.ctorParameters = function () { return [
        { type: TemplateRef }
    ]; };
    return NgbPanelContent;
}());
export { NgbPanelContent };
if (false) {
    /** @type {?} */
    NgbPanelContent.prototype.templateRef;
}
/**
 * The NgbPanel directive represents an individual panel with the title and collapsible
 * content
 */
var NgbPanel = /** @class */ (function () {
    function NgbPanel() {
        /**
         *  A flag determining whether the panel is disabled or not.
         *  When disabled, the panel cannot be toggled.
         */
        this.disabled = false;
        /**
         *  An optional id for the panel. The id should be unique.
         *  If not provided, it will be auto-generated.
         */
        this.id = "ngb-panel-" + nextId++;
        /**
         * A flag telling if the panel is currently open
         */
        this.isOpen = false;
    }
    /**
     * @return {?}
     */
    NgbPanel.prototype.ngAfterContentChecked = /**
     * @return {?}
     */
    function () {
        // We are using @ContentChildren instead of @ContentChild as in the Angular version being used
        // only @ContentChildren allows us to specify the {descendants: false} option.
        // Without {descendants: false} we are hitting bugs described in:
        // https://github.com/ng-bootstrap/ng-bootstrap/issues/2240
        this.titleTpl = this.titleTpls.first;
        this.contentTpl = this.contentTpls.first;
    };
    NgbPanel.decorators = [
        { type: Directive, args: [{ selector: 'ngb-panel' },] }
    ];
    NgbPanel.propDecorators = {
        disabled: [{ type: Input }],
        id: [{ type: Input }],
        title: [{ type: Input }],
        type: [{ type: Input }],
        titleTpls: [{ type: ContentChildren, args: [NgbPanelTitle, { descendants: false },] }],
        contentTpls: [{ type: ContentChildren, args: [NgbPanelContent, { descendants: false },] }]
    };
    return NgbPanel;
}());
export { NgbPanel };
if (false) {
    /**
     *  A flag determining whether the panel is disabled or not.
     *  When disabled, the panel cannot be toggled.
     * @type {?}
     */
    NgbPanel.prototype.disabled;
    /**
     *  An optional id for the panel. The id should be unique.
     *  If not provided, it will be auto-generated.
     * @type {?}
     */
    NgbPanel.prototype.id;
    /**
     * A flag telling if the panel is currently open
     * @type {?}
     */
    NgbPanel.prototype.isOpen;
    /**
     *  The title for the panel.
     * @type {?}
     */
    NgbPanel.prototype.title;
    /**
     *  Accordion's types of panels to be applied per panel basis.
     *  Bootstrap recognizes the following types: "primary", "secondary", "success", "danger", "warning", "info", "light"
     * and "dark"
     * @type {?}
     */
    NgbPanel.prototype.type;
    /** @type {?} */
    NgbPanel.prototype.titleTpl;
    /** @type {?} */
    NgbPanel.prototype.contentTpl;
    /** @type {?} */
    NgbPanel.prototype.titleTpls;
    /** @type {?} */
    NgbPanel.prototype.contentTpls;
}
/**
 * The payload of the change event fired right before toggling an accordion panel
 * @record
 */
export function NgbPanelChangeEvent() { }
if (false) {
    /**
     * Id of the accordion panel that is toggled
     * @type {?}
     */
    NgbPanelChangeEvent.prototype.panelId;
    /**
     * Whether the panel will be opened (true) or closed (false)
     * @type {?}
     */
    NgbPanelChangeEvent.prototype.nextState;
    /**
     * Function that will prevent panel toggling if called
     * @type {?}
     */
    NgbPanelChangeEvent.prototype.preventDefault;
}
/**
 * The NgbAccordion directive is a collection of panels.
 * It can assure that only one panel can be opened at a time.
 */
var NgbAccordion = /** @class */ (function () {
    function NgbAccordion(config) {
        /**
         * An array or comma separated strings of panel identifiers that should be opened
         */
        this.activeIds = [];
        /**
         * Whether the closed panels should be hidden without destroying them
         */
        this.destroyOnHide = true;
        /**
         * A panel change event fired right before the panel toggle happens. See NgbPanelChangeEvent for payload details
         */
        this.panelChange = new EventEmitter();
        this.type = config.type;
        this.closeOtherPanels = config.closeOthers;
    }
    /**
     * Checks if a panel with a given id is expanded or not.
     */
    /**
     * Checks if a panel with a given id is expanded or not.
     * @param {?} panelId
     * @return {?}
     */
    NgbAccordion.prototype.isExpanded = /**
     * Checks if a panel with a given id is expanded or not.
     * @param {?} panelId
     * @return {?}
     */
    function (panelId) { return this.activeIds.indexOf(panelId) > -1; };
    /**
     * Expands a panel with a given id. Has no effect if the panel is already expanded or disabled.
     */
    /**
     * Expands a panel with a given id. Has no effect if the panel is already expanded or disabled.
     * @param {?} panelId
     * @return {?}
     */
    NgbAccordion.prototype.expand = /**
     * Expands a panel with a given id. Has no effect if the panel is already expanded or disabled.
     * @param {?} panelId
     * @return {?}
     */
    function (panelId) { this._changeOpenState(this._findPanelById(panelId), true); };
    /**
     * Expands all panels if [closeOthers]="false". For the [closeOthers]="true" case will have no effect if there is an
     * open panel, otherwise the first panel will be expanded.
     */
    /**
     * Expands all panels if [closeOthers]="false". For the [closeOthers]="true" case will have no effect if there is an
     * open panel, otherwise the first panel will be expanded.
     * @return {?}
     */
    NgbAccordion.prototype.expandAll = /**
     * Expands all panels if [closeOthers]="false". For the [closeOthers]="true" case will have no effect if there is an
     * open panel, otherwise the first panel will be expanded.
     * @return {?}
     */
    function () {
        var _this = this;
        if (this.closeOtherPanels) {
            if (this.activeIds.length === 0 && this.panels.length) {
                this._changeOpenState(this.panels.first, true);
            }
        }
        else {
            this.panels.forEach(function (panel) { return _this._changeOpenState(panel, true); });
        }
    };
    /**
     * Collapses a panel with a given id. Has no effect if the panel is already collapsed or disabled.
     */
    /**
     * Collapses a panel with a given id. Has no effect if the panel is already collapsed or disabled.
     * @param {?} panelId
     * @return {?}
     */
    NgbAccordion.prototype.collapse = /**
     * Collapses a panel with a given id. Has no effect if the panel is already collapsed or disabled.
     * @param {?} panelId
     * @return {?}
     */
    function (panelId) { this._changeOpenState(this._findPanelById(panelId), false); };
    /**
     * Collapses all open panels.
     */
    /**
     * Collapses all open panels.
     * @return {?}
     */
    NgbAccordion.prototype.collapseAll = /**
     * Collapses all open panels.
     * @return {?}
     */
    function () {
        var _this = this;
        this.panels.forEach(function (panel) { _this._changeOpenState(panel, false); });
    };
    /**
     * Programmatically toggle a panel with a given id. Has no effect if the panel is disabled.
     */
    /**
     * Programmatically toggle a panel with a given id. Has no effect if the panel is disabled.
     * @param {?} panelId
     * @return {?}
     */
    NgbAccordion.prototype.toggle = /**
     * Programmatically toggle a panel with a given id. Has no effect if the panel is disabled.
     * @param {?} panelId
     * @return {?}
     */
    function (panelId) {
        /** @type {?} */
        var panel = this._findPanelById(panelId);
        if (panel) {
            this._changeOpenState(panel, !panel.isOpen);
        }
    };
    /**
     * @return {?}
     */
    NgbAccordion.prototype.ngAfterContentChecked = /**
     * @return {?}
     */
    function () {
        var _this = this;
        // active id updates
        if (isString(this.activeIds)) {
            this.activeIds = this.activeIds.split(/\s*,\s*/);
        }
        // update panels open states
        this.panels.forEach(function (panel) { return panel.isOpen = !panel.disabled && _this.activeIds.indexOf(panel.id) > -1; });
        // closeOthers updates
        if (this.activeIds.length > 1 && this.closeOtherPanels) {
            this._closeOthers(this.activeIds[0]);
            this._updateActiveIds();
        }
    };
    /**
     * @param {?} panel
     * @param {?} nextState
     * @return {?}
     */
    NgbAccordion.prototype._changeOpenState = /**
     * @param {?} panel
     * @param {?} nextState
     * @return {?}
     */
    function (panel, nextState) {
        if (panel && !panel.disabled && panel.isOpen !== nextState) {
            /** @type {?} */
            var defaultPrevented_1 = false;
            this.panelChange.emit({ panelId: panel.id, nextState: nextState, preventDefault: function () { defaultPrevented_1 = true; } });
            if (!defaultPrevented_1) {
                panel.isOpen = nextState;
                if (nextState && this.closeOtherPanels) {
                    this._closeOthers(panel.id);
                }
                this._updateActiveIds();
            }
        }
    };
    /**
     * @param {?} panelId
     * @return {?}
     */
    NgbAccordion.prototype._closeOthers = /**
     * @param {?} panelId
     * @return {?}
     */
    function (panelId) {
        this.panels.forEach(function (panel) {
            if (panel.id !== panelId) {
                panel.isOpen = false;
            }
        });
    };
    /**
     * @param {?} panelId
     * @return {?}
     */
    NgbAccordion.prototype._findPanelById = /**
     * @param {?} panelId
     * @return {?}
     */
    function (panelId) { return this.panels.find(function (p) { return p.id === panelId; }); };
    /**
     * @return {?}
     */
    NgbAccordion.prototype._updateActiveIds = /**
     * @return {?}
     */
    function () {
        this.activeIds = this.panels.filter(function (panel) { return panel.isOpen && !panel.disabled; }).map(function (panel) { return panel.id; });
    };
    NgbAccordion.decorators = [
        { type: Component, args: [{
                    selector: 'ngb-accordion',
                    exportAs: 'ngbAccordion',
                    host: { 'class': 'accordion', 'role': 'tablist', '[attr.aria-multiselectable]': '!closeOtherPanels' },
                    template: "\n    <ng-template ngFor let-panel [ngForOf]=\"panels\">\n      <div class=\"card\">\n        <div role=\"tab\" id=\"{{panel.id}}-header\" [class]=\"'card-header ' + (panel.type ? 'bg-'+panel.type: type ? 'bg-'+type : '')\">\n          <h5 class=\"mb-0\">\n            <button type=\"button\" class=\"btn btn-link\"\n              (click)=\"toggle(panel.id)\" [disabled]=\"panel.disabled\" [class.collapsed]=\"!panel.isOpen\"\n              [attr.aria-expanded]=\"panel.isOpen\" [attr.aria-controls]=\"panel.id\">\n              {{panel.title}}<ng-template [ngTemplateOutlet]=\"panel.titleTpl?.templateRef\"></ng-template>\n            </button>\n          </h5>\n        </div>\n        <div id=\"{{panel.id}}\" role=\"tabpanel\" [attr.aria-labelledby]=\"panel.id + '-header'\"\n             class=\"collapse\" [class.show]=\"panel.isOpen\" *ngIf=\"!destroyOnHide || panel.isOpen\">\n          <div class=\"card-body\">\n               <ng-template [ngTemplateOutlet]=\"panel.contentTpl?.templateRef\"></ng-template>\n          </div>\n        </div>\n      </div>\n    </ng-template>\n  "
                }] }
    ];
    /** @nocollapse */
    NgbAccordion.ctorParameters = function () { return [
        { type: NgbAccordionConfig }
    ]; };
    NgbAccordion.propDecorators = {
        panels: [{ type: ContentChildren, args: [NgbPanel,] }],
        activeIds: [{ type: Input }],
        closeOtherPanels: [{ type: Input, args: ['closeOthers',] }],
        destroyOnHide: [{ type: Input }],
        type: [{ type: Input }],
        panelChange: [{ type: Output }]
    };
    return NgbAccordion;
}());
export { NgbAccordion };
if (false) {
    /** @type {?} */
    NgbAccordion.prototype.panels;
    /**
     * An array or comma separated strings of panel identifiers that should be opened
     * @type {?}
     */
    NgbAccordion.prototype.activeIds;
    /**
     *  Whether the other panels should be closed when a panel is opened
     * @type {?}
     */
    NgbAccordion.prototype.closeOtherPanels;
    /**
     * Whether the closed panels should be hidden without destroying them
     * @type {?}
     */
    NgbAccordion.prototype.destroyOnHide;
    /**
     *  Accordion's types of panels to be applied globally.
     *  Bootstrap recognizes the following types: "primary", "secondary", "success", "danger", "warning", "info", "light"
     * and "dark
     * @type {?}
     */
    NgbAccordion.prototype.type;
    /**
     * A panel change event fired right before the panel toggle happens. See NgbPanelChangeEvent for payload details
     * @type {?}
     */
    NgbAccordion.prototype.panelChange;
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYWNjb3JkaW9uLmpzIiwic291cmNlUm9vdCI6Im5nOi8vQG5nLWJvb3RzdHJhcC9uZy1ib290c3RyYXAvIiwic291cmNlcyI6WyJhY2NvcmRpb24vYWNjb3JkaW9uLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7Ozs7QUFBQSxPQUFPLEVBRUwsU0FBUyxFQUNULGVBQWUsRUFDZixTQUFTLEVBQ1QsWUFBWSxFQUNaLEtBQUssRUFDTCxNQUFNLEVBQ04sU0FBUyxFQUNULFdBQVcsRUFDWixNQUFNLGVBQWUsQ0FBQztBQUV2QixPQUFPLEVBQUMsUUFBUSxFQUFDLE1BQU0sY0FBYyxDQUFDO0FBRXRDLE9BQU8sRUFBQyxrQkFBa0IsRUFBQyxNQUFNLG9CQUFvQixDQUFDOztJQUVsRCxNQUFNLEdBQUcsQ0FBQzs7OztBQUtkO0lBRUUsdUJBQW1CLFdBQTZCO1FBQTdCLGdCQUFXLEdBQVgsV0FBVyxDQUFrQjtJQUFHLENBQUM7O2dCQUZyRCxTQUFTLFNBQUMsRUFBQyxRQUFRLEVBQUUsNEJBQTRCLEVBQUM7Ozs7Z0JBWmpELFdBQVc7O0lBZWIsb0JBQUM7Q0FBQSxBQUhELElBR0M7U0FGWSxhQUFhOzs7SUFDWixvQ0FBb0M7Ozs7O0FBTWxEO0lBRUUseUJBQW1CLFdBQTZCO1FBQTdCLGdCQUFXLEdBQVgsV0FBVyxDQUFrQjtJQUFHLENBQUM7O2dCQUZyRCxTQUFTLFNBQUMsRUFBQyxRQUFRLEVBQUUsOEJBQThCLEVBQUM7Ozs7Z0JBcEJuRCxXQUFXOztJQXVCYixzQkFBQztDQUFBLEFBSEQsSUFHQztTQUZZLGVBQWU7OztJQUNkLHNDQUFvQzs7Ozs7O0FBT2xEO0lBQUE7Ozs7O1FBTVcsYUFBUSxHQUFHLEtBQUssQ0FBQzs7Ozs7UUFNakIsT0FBRSxHQUFHLGVBQWEsTUFBTSxFQUFJLENBQUM7Ozs7UUFLdEMsV0FBTSxHQUFHLEtBQUssQ0FBQztJQTRCakIsQ0FBQzs7OztJQVJDLHdDQUFxQjs7O0lBQXJCO1FBQ0UsOEZBQThGO1FBQzlGLDhFQUE4RTtRQUM5RSxp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QUksT0FBQSxLQUFLLENBQUMsRUFBRSxFQUFSLENBQVEsQ0FBQyxDQUFDO0lBQ3ZHLENBQUM7O2dCQXpKRixTQUFTLFNBQUM7b0JBQ1QsUUFBUSxFQUFFLGVBQWU7b0JBQ3pCLFFBQVEsRUFBRSxjQUFjO29CQUN4QixJQUFJLEVBQUUsRUFBQyxPQUFPLEVBQUUsV0FBVyxFQUFFLE1BQU0sRUFBRSxTQUFTLEVBQUUsNkJBQTZCLEVBQUUsbUJBQW1CLEVBQUM7b0JBQ25HLFFBQVEsRUFBRSxta0NBb0JUO2lCQUNGOzs7O2dCQXhITyxrQkFBa0I7Ozt5QkEwSHZCLGVBQWUsU0FBQyxRQUFROzRCQUt4QixLQUFLO21DQUtMLEtBQUssU0FBQyxhQUFhO2dDQUtuQixLQUFLO3VCQU9MLEtBQUs7OEJBS0wsTUFBTTs7SUFvR1QsbUJBQUM7Q0FBQSxBQTFKRCxJQTBKQztTQWhJWSxZQUFZOzs7SUFDdkIsOEJBQXVEOzs7OztJQUt2RCxpQ0FBMkM7Ozs7O0lBSzNDLHdDQUFnRDs7Ozs7SUFLaEQscUNBQThCOzs7Ozs7O0lBTzlCLDRCQUFzQjs7Ozs7SUFLdEIsbUNBQWdFIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHtcbiAgQWZ0ZXJDb250ZW50Q2hlY2tlZCxcbiAgQ29tcG9uZW50LFxuICBDb250ZW50Q2hpbGRyZW4sXG4gIERpcmVjdGl2ZSxcbiAgRXZlbnRFbWl0dGVyLFxuICBJbnB1dCxcbiAgT3V0cHV0LFxuICBRdWVyeUxpc3QsXG4gIFRlbXBsYXRlUmVmXG59IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuXG5pbXBvcnQge2lzU3RyaW5nfSBmcm9tICcuLi91dGlsL3V0aWwnO1xuXG5pbXBvcnQge05nYkFjY29yZGlvbkNvbmZpZ30gZnJvbSAnLi9hY2NvcmRpb24tY29uZmlnJztcblxubGV0IG5leHRJZCA9IDA7XG5cbi8qKlxuICogVGhpcyBkaXJlY3RpdmUgc2hvdWxkIGJlIHVzZWQgdG8gd3JhcCBhY2NvcmRpb24gcGFuZWwgdGl0bGVzIHRoYXQgbmVlZCB0byBjb250YWluIEhUTUwgbWFya3VwIG9yIG90aGVyIGRpcmVjdGl2ZXMuXG4gKi9cbkBEaXJlY3RpdmUoe3NlbGVjdG9yOiAnbmctdGVtcGxhdGVbbmdiUGFuZWxUaXRsZV0nfSlcbmV4cG9ydCBjbGFzcyBOZ2JQYW5lbFRpdGxlIHtcbiAgY29uc3RydWN0b3IocHVibGljIHRlbXBsYXRlUmVmOiBUZW1wbGF0ZVJlZjxhbnk+KSB7fVxufVxuXG4vKipcbiAqIFRoaXMgZGlyZWN0aXZlIG11c3QgYmUgdXNlZCB0byB3cmFwIGFjY29yZGlvbiBwYW5lbCBjb250ZW50LlxuICovXG5ARGlyZWN0aXZlKHtzZWxlY3RvcjogJ25nLXRlbXBsYXRlW25nYlBhbmVsQ29udGVudF0nfSlcbmV4cG9ydCBjbGFzcyBOZ2JQYW5lbENvbnRlbnQge1xuICBjb25zdHJ1Y3RvcihwdWJsaWMgdGVtcGxhdGVSZWY6IFRlbXBsYXRlUmVmPGFueT4pIHt9XG59XG5cbi8qKlxuICogVGhlIE5nYlBhbmVsIGRpcmVjdGl2ZSByZXByZXNlbnRzIGFuIGluZGl2aWR1YWwgcGFuZWwgd2l0aCB0aGUgdGl0bGUgYW5kIGNvbGxhcHNpYmxlXG4gKiBjb250ZW50XG4gKi9cbkBEaXJlY3RpdmUoe3NlbGVjdG9yOiAnbmdiLXBhbmVsJ30pXG5leHBvcnQgY2xhc3MgTmdiUGFuZWwgaW1wbGVtZW50cyBBZnRlckNvbnRlbnRDaGVja2VkIHtcbiAgLyoqXG4gICAqICBBIGZsYWcgZGV0ZXJtaW5pbmcgd2hldGhlciB0aGUgcGFuZWwgaXMgZGlzYWJsZWQgb3Igbm90LlxuICAgKiAgV2hlbiBkaXNhYmxlZCwgdGhlIHBhbmVsIGNhbm5vdCBiZSB0b2dnbGVkLlxuICAgKi9cbiAgQElucHV0KCkgZGlzYWJsZWQgPSBmYWxzZTtcblxuICAvKipcbiAgICogIEFuIG9wdGlvbmFsIGlkIGZvciB0aGUgcGFuZWwuIFRoZSBpZCBzaG91bGQgYmUgdW5pcXVlLlxuICAgKiAgSWYgbm90IHByb3ZpZGVkLCBpdCB3aWxsIGJlIGF1dG8tZ2VuZXJhdGVkLlxuICAgKi9cbiAgQElucHV0KCkgaWQgPSBgbmdiLXBhbmVsLSR7bmV4dElkKyt9YDtcblxuICAvKipcbiAgICogQSBmbGFnIHRlbGxpbmcgaWYgdGhlIHBhbmVsIGlzIGN1cnJlbnRseSBvcGVuXG4gICAqL1xuICBpc09wZW4gPSBmYWxzZTtcblxuICAvKipcbiAgICogIFRoZSB0aXRsZSBmb3IgdGhlIHBhbmVsLlxuICAgKi9cbiAgQElucHV0KCkgdGl0bGU6IHN0cmluZztcblxuICAvKipcbiAgICogIEFjY29yZGlvbidzIHR5cGVzIG9mIHBhbmVscyB0byBiZSBhcHBsaWVkIHBlciBwYW5lbCBiYXNpcy5cbiAgICogIEJvb3RzdHJhcCByZWNvZ25pemVzIHRoZSBmb2xsb3dpbmcgdHlwZXM6IFwicHJpbWFyeVwiLCBcInNlY29uZGFyeVwiLCBcInN1Y2Nlc3NcIiwgXCJkYW5nZXJcIiwgXCJ3YXJuaW5nXCIsIFwiaW5mb1wiLCBcImxpZ2h0XCJcbiAgICogYW5kIFwiZGFya1wiXG4gICAqL1xuICBASW5wdXQoKSB0eXBlOiBzdHJpbmc7XG5cbiAgdGl0bGVUcGw6IE5nYlBhbmVsVGl0bGUgfCBudWxsO1xuICBjb250ZW50VHBsOiBOZ2JQYW5lbENvbnRlbnQgfCBudWxsO1xuXG4gIEBDb250ZW50Q2hpbGRyZW4oTmdiUGFuZWxUaXRsZSwge2Rlc2NlbmRhbnRzOiBmYWxzZX0pIHRpdGxlVHBsczogUXVlcnlMaXN0PE5nYlBhbmVsVGl0bGU+O1xuICBAQ29udGVudENoaWxkcmVuKE5nYlBhbmVsQ29udGVudCwge2Rlc2NlbmRhbnRzOiBmYWxzZX0pIGNvbnRlbnRUcGxzOiBRdWVyeUxpc3Q8TmdiUGFuZWxDb250ZW50PjtcblxuICBuZ0FmdGVyQ29udGVudENoZWNrZWQoKSB7XG4gICAgLy8gV2UgYXJlIHVzaW5nIEBDb250ZW50Q2hpbGRyZW4gaW5zdGVhZCBvZiBAQ29udGVudENoaWxkIGFzIGluIHRoZSBBbmd1bGFyIHZlcnNpb24gYmVpbmcgdXNlZFxuICAgIC8vIG9ubHkgQENvbnRlbnRDaGlsZHJlbiBhbGxvd3MgdXMgdG8gc3BlY2lmeSB0aGUge2Rlc2NlbmRhbnRzOiBmYWxzZX0gb3B0aW9uLlxuICAgIC8vIFdpdGhvdXQge2Rlc2NlbmRhbnRzOiBmYWxzZX0gd2UgYXJlIGhpdHRpbmcgYnVncyBkZXNjcmliZWQgaW46XG4gICAgLy8gaHR0cHM6Ly9naXRodWIuY29tL25nLWJvb3RzdHJhcC9uZy1ib290c3RyYXAvaXNzdWVzLzIyNDBcbiAgICB0aGlzLnRpdGxlVHBsID0gdGhpcy50aXRsZVRwbHMuZmlyc3Q7XG4gICAgdGhpcy5jb250ZW50VHBsID0gdGhpcy5jb250ZW50VHBscy5maXJzdDtcbiAgfVxufVxuXG4vKipcbiAqIFRoZSBwYXlsb2FkIG9mIHRoZSBjaGFuZ2UgZXZlbnQgZmlyZWQgcmlnaHQgYmVmb3JlIHRvZ2dsaW5nIGFuIGFjY29yZGlvbiBwYW5lbFxuICovXG5leHBvcnQgaW50ZXJmYWNlIE5nYlBhbmVsQ2hhbmdlRXZlbnQge1xuICAvKipcbiAgICogSWQgb2YgdGhlIGFjY29yZGlvbiBwYW5lbCB0aGF0IGlzIHRvZ2dsZWRcbiAgICovXG4gIHBhbmVsSWQ6IHN0cmluZztcblxuICAvKipcbiAgICogV2hldGhlciB0aGUgcGFuZWwgd2lsbCBiZSBvcGVuZWQgKHRydWUpIG9yIGNsb3NlZCAoZmFsc2UpXG4gICAqL1xuICBuZXh0U3RhdGU6IGJvb2xlYW47XG5cbiAgLyoqXG4gICAqIEZ1bmN0aW9uIHRoYXQgd2lsbCBwcmV2ZW50IHBhbmVsIHRvZ2dsaW5nIGlmIGNhbGxlZFxuICAgKi9cbiAgcHJldmVudERlZmF1bHQ6ICgpID0+IHZvaWQ7XG59XG5cbi8qKlxuICogVGhlIE5nYkFjY29yZGlvbiBkaXJlY3RpdmUgaXMgYSBjb2xsZWN0aW9uIG9mIHBhbmVscy5cbiAqIEl0IGNhbiBhc3N1cmUgdGhhdCBvbmx5IG9uZSBwYW5lbCBjYW4gYmUgb3BlbmVkIGF0IGEgdGltZS5cbiAqL1xuQENvbXBvbmVudCh7XG4gIHNlbGVjdG9yOiAnbmdiLWFjY29yZGlvbicsXG4gIGV4cG9ydEFzOiAnbmdiQWNjb3JkaW9uJyxcbiAgaG9zdDogeydjbGFzcyc6ICdhY2NvcmRpb24nLCAncm9sZSc6ICd0YWJsaXN0JywgJ1thdHRyLmFyaWEtbXVsdGlzZWxlY3RhYmxlXSc6ICchY2xvc2VPdGhlclBhbmVscyd9LFxuICB0ZW1wbGF0ZTogYFxuICAgIDxuZy10ZW1wbGF0ZSBuZ0ZvciBsZXQtcGFuZWwgW25nRm9yT2ZdPVwicGFuZWxzXCI+XG4gICAgICA8ZGl2IGNsYXNzPVwiY2FyZFwiPlxuICAgICAgICA8ZGl2IHJvbGU9XCJ0YWJcIiBpZD1cInt7cGFuZWwuaWR9fS1oZWFkZXJcIiBbY2xhc3NdPVwiJ2NhcmQtaGVhZGVyICcgKyAocGFuZWwudHlwZSA/ICdiZy0nK3BhbmVsLnR5cGU6IHR5cGUgPyAnYmctJyt0eXBlIDogJycpXCI+XG4gICAgICAgICAgPGg1IGNsYXNzPVwibWItMFwiPlxuICAgICAgICAgICAgPGJ1dHRvbiB0eXBlPVwiYnV0dG9uXCIgY2xhc3M9XCJidG4gYnRuLWxpbmtcIlxuICAgICAgICAgICAgICAoY2xpY2spPVwidG9nZ2xlKHBhbmVsLmlkKVwiIFtkaXNhYmxlZF09XCJwYW5lbC5kaXNhYmxlZFwiIFtjbGFzcy5jb2xsYXBzZWRdPVwiIXBhbmVsLmlzT3BlblwiXG4gICAgICAgICAgICAgIFthdHRyLmFyaWEtZXhwYW5kZWRdPVwicGFuZWwuaXNPcGVuXCIgW2F0dHIuYXJpYS1jb250cm9sc109XCJwYW5lbC5pZFwiPlxuICAgICAgICAgICAgICB7e3BhbmVsLnRpdGxlfX08bmctdGVtcGxhdGUgW25nVGVtcGxhdGVPdXRsZXRdPVwicGFuZWwudGl0bGVUcGw/LnRlbXBsYXRlUmVmXCI+PC9uZy10ZW1wbGF0ZT5cbiAgICAgICAgICAgIDwvYnV0dG9uPlxuICAgICAgICAgIDwvaDU+XG4gICAgICAgIDwvZGl2PlxuICAgICAgICA8ZGl2IGlkPVwie3twYW5lbC5pZH19XCIgcm9sZT1cInRhYnBhbmVsXCIgW2F0dHIuYXJpYS1sYWJlbGxlZGJ5XT1cInBhbmVsLmlkICsgJy1oZWFkZXInXCJcbiAgICAgICAgICAgICBjbGFzcz1cImNvbGxhcHNlXCIgW2NsYXNzLnNob3ddPVwicGFuZWwuaXNPcGVuXCIgKm5nSWY9XCIhZGVzdHJveU9uSGlkZSB8fCBwYW5lbC5pc09wZW5cIj5cbiAgICAgICAgICA8ZGl2IGNsYXNzPVwiY2FyZC1ib2R5XCI+XG4gICAgICAgICAgICAgICA8bmctdGVtcGxhdGUgW25nVGVtcGxhdGVPdXRsZXRdPVwicGFuZWwuY29udGVudFRwbD8udGVtcGxhdGVSZWZcIj48L25nLXRlbXBsYXRlPlxuICAgICAgICAgIDwvZGl2PlxuICAgICAgICA8L2Rpdj5cbiAgICAgIDwvZGl2PlxuICAgIDwvbmctdGVtcGxhdGU+XG4gIGBcbn0pXG5leHBvcnQgY2xhc3MgTmdiQWNjb3JkaW9uIGltcGxlbWVudHMgQWZ0ZXJDb250ZW50Q2hlY2tlZCB7XG4gIEBDb250ZW50Q2hpbGRyZW4oTmdiUGFuZWwpIHBhbmVsczogUXVlcnlMaXN0PE5nYlBhbmVsPjtcblxuICAvKipcbiAgICogQW4gYXJyYXkgb3IgY29tbWEgc2VwYXJhdGVkIHN0cmluZ3Mgb2YgcGFuZWwgaWRlbnRpZmllcnMgdGhhdCBzaG91bGQgYmUgb3BlbmVkXG4gICAqL1xuICBASW5wdXQoKSBhY3RpdmVJZHM6IHN0cmluZyB8IHN0cmluZ1tdID0gW107XG5cbiAgLyoqXG4gICAqICBXaGV0aGVyIHRoZSBvdGhlciBwYW5lbHMgc2hvdWxkIGJlIGNsb3NlZCB3aGVuIGEgcGFuZWwgaXMgb3BlbmVkXG4gICAqL1xuICBASW5wdXQoJ2Nsb3NlT3RoZXJzJykgY2xvc2VPdGhlclBhbmVsczogYm9vbGVhbjtcblxuICAvKipcbiAgICogV2hldGhlciB0aGUgY2xvc2VkIHBhbmVscyBzaG91bGQgYmUgaGlkZGVuIHdpdGhvdXQgZGVzdHJveWluZyB0aGVtXG4gICAqL1xuICBASW5wdXQoKSBkZXN0cm95T25IaWRlID0gdHJ1ZTtcblxuICAvKipcbiAgICogIEFjY29yZGlvbidzIHR5cGVzIG9mIHBhbmVscyB0byBiZSBhcHBsaWVkIGdsb2JhbGx5LlxuICAgKiAgQm9vdHN0cmFwIHJlY29nbml6ZXMgdGhlIGZvbGxvd2luZyB0eXBlczogXCJwcmltYXJ5XCIsIFwic2Vjb25kYXJ5XCIsIFwic3VjY2Vzc1wiLCBcImRhbmdlclwiLCBcIndhcm5pbmdcIiwgXCJpbmZvXCIsIFwibGlnaHRcIlxuICAgKiBhbmQgXCJkYXJrXG4gICAqL1xuICBASW5wdXQoKSB0eXBlOiBzdHJpbmc7XG5cbiAgLyoqXG4gICAqIEEgcGFuZWwgY2hhbmdlIGV2ZW50IGZpcmVkIHJpZ2h0IGJlZm9yZSB0aGUgcGFuZWwgdG9nZ2xlIGhhcHBlbnMuIFNlZSBOZ2JQYW5lbENoYW5nZUV2ZW50IGZvciBwYXlsb2FkIGRldGFpbHNcbiAgICovXG4gIEBPdXRwdXQoKSBwYW5lbENoYW5nZSA9IG5ldyBFdmVudEVtaXR0ZXI8TmdiUGFuZWxDaGFuZ2VFdmVudD4oKTtcblxuICBjb25zdHJ1Y3Rvcihjb25maWc6IE5nYkFjY29yZGlvbkNvbmZpZykge1xuICAgIHRoaXMudHlwZSA9IGNvbmZpZy50eXBlO1xuICAgIHRoaXMuY2xvc2VPdGhlclBhbmVscyA9IGNvbmZpZy5jbG9zZU90aGVycztcbiAgfVxuXG4gIC8qKlxuICAgKiBDaGVja3MgaWYgYSBwYW5lbCB3aXRoIGEgZ2l2ZW4gaWQgaXMgZXhwYW5kZWQgb3Igbm90LlxuICAgKi9cbiAgaXNFeHBhbmRlZChwYW5lbElkOiBzdHJpbmcpOiBib29sZWFuIHsgcmV0dXJuIHRoaXMuYWN0aXZlSWRzLmluZGV4T2YocGFuZWxJZCkgPiAtMTsgfVxuXG4gIC8qKlxuICAgKiBFeHBhbmRzIGEgcGFuZWwgd2l0aCBhIGdpdmVuIGlkLiBIYXMgbm8gZWZmZWN0IGlmIHRoZSBwYW5lbCBpcyBhbHJlYWR5IGV4cGFuZGVkIG9yIGRpc2FibGVkLlxuICAgKi9cbiAgZXhwYW5kKHBhbmVsSWQ6IHN0cmluZyk6IHZvaWQgeyB0aGlzLl9jaGFuZ2VPcGVuU3RhdGUodGhpcy5fZmluZFBhbmVsQnlJZChwYW5lbElkKSwgdHJ1ZSk7IH1cblxuICAvKipcbiAgICogRXhwYW5kcyBhbGwgcGFuZWxzIGlmIFtjbG9zZU90aGVyc109XCJmYWxzZVwiLiBGb3IgdGhlIFtjbG9zZU90aGVyc109XCJ0cnVlXCIgY2FzZSB3aWxsIGhhdmUgbm8gZWZmZWN0IGlmIHRoZXJlIGlzIGFuXG4gICAqIG9wZW4gcGFuZWwsIG90aGVyd2lzZSB0aGUgZmlyc3QgcGFuZWwgd2lsbCBiZSBleHBhbmRlZC5cbiAgICovXG4gIGV4cGFuZEFsbCgpOiB2b2lkIHtcbiAgICBpZiAodGhpcy5jbG9zZU90aGVyUGFuZWxzKSB7XG4gICAgICBpZiAodGhpcy5hY3RpdmVJZHMubGVuZ3RoID09PSAwICYmIHRoaXMucGFuZWxzLmxlbmd0aCkge1xuICAgICAgICB0aGlzLl9jaGFuZ2VPcGVuU3RhdGUodGhpcy5wYW5lbHMuZmlyc3QsIHRydWUpO1xuICAgICAgfVxuICAgIH0gZWxzZSB7XG4gICAgICB0aGlzLnBhbmVscy5mb3JFYWNoKHBhbmVsID0+IHRoaXMuX2NoYW5nZU9wZW5TdGF0ZShwYW5lbCwgdHJ1ZSkpO1xuICAgIH1cbiAgfVxuXG4gIC8qKlxuICAgKiBDb2xsYXBzZXMgYSBwYW5lbCB3aXRoIGEgZ2l2ZW4gaWQuIEhhcyBubyBlZmZlY3QgaWYgdGhlIHBhbmVsIGlzIGFscmVhZHkgY29sbGFwc2VkIG9yIGRpc2FibGVkLlxuICAgKi9cbiAgY29sbGFwc2UocGFuZWxJZDogc3RyaW5nKSB7IHRoaXMuX2NoYW5nZU9wZW5TdGF0ZSh0aGlzLl9maW5kUGFuZWxCeUlkKHBhbmVsSWQpLCBmYWxzZSk7IH1cblxuICAvKipcbiAgICogQ29sbGFwc2VzIGFsbCBvcGVuIHBhbmVscy5cbiAgICovXG4gIGNvbGxhcHNlQWxsKCkge1xuICAgIHRoaXMucGFuZWxzLmZvckVhY2goKHBhbmVsKSA9PiB7IHRoaXMuX2NoYW5nZU9wZW5TdGF0ZShwYW5lbCwgZmFsc2UpOyB9KTtcbiAgfVxuXG4gIC8qKlxuICAgKiBQcm9ncmFtbWF0aWNhbGx5IHRvZ2dsZSBhIHBhbmVsIHdpdGggYSBnaXZlbiBpZC4gSGFzIG5vIGVmZmVjdCBpZiB0aGUgcGFuZWwgaXMgZGlzYWJsZWQuXG4gICAqL1xuICB0b2dnbGUocGFuZWxJZDogc3RyaW5nKSB7XG4gICAgY29uc3QgcGFuZWwgPSB0aGlzLl9maW5kUGFuZWxCeUlkKHBhbmVsSWQpO1xuICAgIGlmIChwYW5lbCkge1xuICAgICAgdGhpcy5fY2hhbmdlT3BlblN0YXRlKHBhbmVsLCAhcGFuZWwuaXNPcGVuKTtcbiAgICB9XG4gIH1cblxuICBuZ0FmdGVyQ29udGVudENoZWNrZWQoKSB7XG4gICAgLy8gYWN0aXZlIGlkIHVwZGF0ZXNcbiAgICBpZiAoaXNTdHJpbmcodGhpcy5hY3RpdmVJZHMpKSB7XG4gICAgICB0aGlzLmFjdGl2ZUlkcyA9IHRoaXMuYWN0aXZlSWRzLnNwbGl0KC9cXHMqLFxccyovKTtcbiAgICB9XG5cbiAgICAvLyB1cGRhdGUgcGFuZWxzIG9wZW4gc3RhdGVzXG4gICAgdGhpcy5wYW5lbHMuZm9yRWFjaChwYW5lbCA9PiBwYW5lbC5pc09wZW4gPSAhcGFuZWwuZGlzYWJsZWQgJiYgdGhpcy5hY3RpdmVJZHMuaW5kZXhPZihwYW5lbC5pZCkgPiAtMSk7XG5cbiAgICAvLyBjbG9zZU90aGVycyB1cGRhdGVzXG4gICAgaWYgKHRoaXMuYWN0aXZlSWRzLmxlbmd0aCA+IDEgJiYgdGhpcy5jbG9zZU90aGVyUGFuZWxzKSB7XG4gICAgICB0aGlzLl9jbG9zZU90aGVycyh0aGlzLmFjdGl2ZUlkc1swXSk7XG4gICAgICB0aGlzLl91cGRhdGVBY3RpdmVJZHMoKTtcbiAgICB9XG4gIH1cblxuICBwcml2YXRlIF9jaGFuZ2VPcGVuU3RhdGUocGFuZWw6IE5nYlBhbmVsLCBuZXh0U3RhdGU6IGJvb2xlYW4pIHtcbiAgICBpZiAocGFuZWwgJiYgIXBhbmVsLmRpc2FibGVkICYmIHBhbmVsLmlzT3BlbiAhPT0gbmV4dFN0YXRlKSB7XG4gICAgICBsZXQgZGVmYXVsdFByZXZlbnRlZCA9IGZhbHNlO1xuXG4gICAgICB0aGlzLnBhbmVsQ2hhbmdlLmVtaXQoXG4gICAgICAgICAge3BhbmVsSWQ6IHBhbmVsLmlkLCBuZXh0U3RhdGU6IG5leHRTdGF0ZSwgcHJldmVudERlZmF1bHQ6ICgpID0+IHsgZGVmYXVsdFByZXZlbnRlZCA9IHRydWU7IH19KTtcblxuICAgICAgaWYgKCFkZWZhdWx0UHJldmVudGVkKSB7XG4gICAgICAgIHBhbmVsLmlzT3BlbiA9IG5leHRTdGF0ZTtcblxuICAgICAgICBpZiAobmV4dFN0YXRlICYmIHRoaXMuY2xvc2VPdGhlclBhbmVscykge1xuICAgICAgICAgIHRoaXMuX2Nsb3NlT3RoZXJzKHBhbmVsLmlkKTtcbiAgICAgICAgfVxuICAgICAgICB0aGlzLl91cGRhdGVBY3RpdmVJZHMoKTtcbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICBwcml2YXRlIF9jbG9zZU90aGVycyhwYW5lbElkOiBzdHJpbmcpIHtcbiAgICB0aGlzLnBhbmVscy5mb3JFYWNoKHBhbmVsID0+IHtcbiAgICAgIGlmIChwYW5lbC5pZCAhPT0gcGFuZWxJZCkge1xuICAgICAgICBwYW5lbC5pc09wZW4gPSBmYWxzZTtcbiAgICAgIH1cbiAgICB9KTtcbiAgfVxuXG4gIHByaXZhdGUgX2ZpbmRQYW5lbEJ5SWQocGFuZWxJZDogc3RyaW5nKTogTmdiUGFuZWwgfCBudWxsIHsgcmV0dXJuIHRoaXMucGFuZWxzLmZpbmQocCA9PiBwLmlkID09PSBwYW5lbElkKTsgfVxuXG4gIHByaXZhdGUgX3VwZGF0ZUFjdGl2ZUlkcygpIHtcbiAgICB0aGlzLmFjdGl2ZUlkcyA9IHRoaXMucGFuZWxzLmZpbHRlcihwYW5lbCA9PiBwYW5lbC5pc09wZW4gJiYgIXBhbmVsLmRpc2FibGVkKS5tYXAocGFuZWwgPT4gcGFuZWwuaWQpO1xuICB9XG59XG4iXX0=