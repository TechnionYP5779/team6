/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,uselessCode} checked by tsc
 */
import { Directive, ElementRef, forwardRef, Input, Renderer2 } from '@angular/core';
import { NG_VALUE_ACCESSOR } from '@angular/forms';
import { NgbButtonLabel } from './label';
/** @type {?} */
var NGB_RADIO_VALUE_ACCESSOR = {
    provide: NG_VALUE_ACCESSOR,
    useExisting: forwardRef(function () { return NgbRadioGroup; }),
    multi: true
};
/** @type {?} */
var nextId = 0;
/**
 * Easily create Bootstrap-style radio buttons. A value of a selected button is bound to a variable
 * specified via ngModel.
 */
var NgbRadioGroup = /** @class */ (function () {
    function NgbRadioGroup() {
        this._radios = new Set();
        this._value = null;
        /**
         * The name of the group. Unless enclosed inputs specify a name, this name is used as the name of the
         * enclosed inputs. If not specified, a name is generated automatically.
         */
        this.name = "ngb-radio-" + nextId++;
        this.onChange = function (_) { };
        this.onTouched = function () { };
    }
    Object.defineProperty(NgbRadioGroup.prototype, "disabled", {
        get: /**
         * @return {?}
         */
        function () { return this._disabled; },
        set: /**
         * @param {?} isDisabled
         * @return {?}
         */
        function (isDisabled) { this.setDisabledState(isDisabled); },
        enumerable: true,
        configurable: true
    });
    /**
     * @param {?} radio
     * @return {?}
     */
    NgbRadioGroup.prototype.onRadioChange = /**
     * @param {?} radio
     * @return {?}
     */
    function (radio) {
        this.writeValue(radio.value);
        this.onChange(radio.value);
    };
    /**
     * @return {?}
     */
    NgbRadioGroup.prototype.onRadioValueUpdate = /**
     * @return {?}
     */
    function () { this._updateRadiosValue(); };
    /**
     * @param {?} radio
     * @return {?}
     */
    NgbRadioGroup.prototype.register = /**
     * @param {?} radio
     * @return {?}
     */
    function (radio) { this._radios.add(radio); };
    /**
     * @param {?} fn
     * @return {?}
     */
    NgbRadioGroup.prototype.registerOnChange = /**
     * @param {?} fn
     * @return {?}
     */
    function (fn) { this.onChange = fn; };
    /**
     * @param {?} fn
     * @return {?}
     */
    NgbRadioGroup.prototype.registerOnTouched = /**
     * @param {?} fn
     * @return {?}
     */
    function (fn) { this.onTouched = fn; };
    /**
     * @param {?} isDisabled
     * @return {?}
     */
    NgbRadioGroup.prototype.setDisabledState = /**
     * @param {?} isDisabled
     * @return {?}
     */
    function (isDisabled) {
        this._disabled = isDisabled;
        this._updateRadiosDisabled();
    };
    /**
     * @param {?} radio
     * @return {?}
     */
    NgbRadioGroup.prototype.unregister = /**
     * @param {?} radio
     * @return {?}
     */
    function (radio) { this._radios.delete(radio); };
    /**
     * @param {?} value
     * @return {?}
     */
    NgbRadioGroup.prototype.writeValue = /**
     * @param {?} value
     * @return {?}
     */
    function (value) {
        this._value = value;
        this._updateRadiosValue();
    };
    /**
     * @return {?}
     */
    NgbRadioGroup.prototype._updateRadiosValue = /**
     * @return {?}
     */
    function () {
        var _this = this;
        this._radios.forEach(function (radio) { return radio.updateValue(_this._value); });
    };
    /**
     * @return {?}
     */
    NgbRadioGroup.prototype._updateRadiosDisabled = /**
     * @return {?}
     */
    function () { this._radios.forEach(function (radio) { return radio.updateDisabled(); }); };
    NgbRadioGroup.decorators = [
        { type: Directive, args: [{ selector: '[ngbRadioGroup]', host: { 'role': 'group' }, providers: [NGB_RADIO_VALUE_ACCESSOR] },] }
    ];
    NgbRadioGroup.propDecorators = {
        name: [{ type: Input }]
    };
    return NgbRadioGroup;
}());
export { NgbRadioGroup };
if (false) {
    /** @type {?} */
    NgbRadioGroup.prototype._radios;
    /** @type {?} */
    NgbRadioGroup.prototype._value;
    /** @type {?} */
    NgbRadioGroup.prototype._disabled;
    /**
     * The name of the group. Unless enclosed inputs specify a name, this name is used as the name of the
     * enclosed inputs. If not specified, a name is generated automatically.
     * @type {?}
     */
    NgbRadioGroup.prototype.name;
    /** @type {?} */
    NgbRadioGroup.prototype.onChange;
    /** @type {?} */
    NgbRadioGroup.prototype.onTouched;
}
/**
 * Marks an input of type "radio" as part of the NgbRadioGroup.
 */
var NgbRadio = /** @class */ (function () {
    function NgbRadio(_group, _label, _renderer, _element) {
        this._group = _group;
        this._label = _label;
        this._renderer = _renderer;
        this._element = _element;
        this._value = null;
        this._group.register(this);
        this.updateDisabled();
    }
    Object.defineProperty(NgbRadio.prototype, "value", {
        get: /**
         * @return {?}
         */
        function () { return this._value; },
        /**
         * You can specify model value of a given radio by binding to the value property.
         */
        set: /**
         * You can specify model value of a given radio by binding to the value property.
         * @param {?} value
         * @return {?}
         */
        function (value) {
            this._value = value;
            /** @type {?} */
            var stringValue = value ? value.toString() : '';
            this._renderer.setProperty(this._element.nativeElement, 'value', stringValue);
            this._group.onRadioValueUpdate();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(NgbRadio.prototype, "disabled", {
        get: /**
         * @return {?}
         */
        function () { return this._group.disabled || this._disabled; },
        /**
         * A flag indicating if a given radio button is disabled.
         */
        set: /**
         * A flag indicating if a given radio button is disabled.
         * @param {?} isDisabled
         * @return {?}
         */
        function (isDisabled) {
            this._disabled = isDisabled !== false;
            this.updateDisabled();
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(NgbRadio.prototype, "focused", {
        set: /**
         * @param {?} isFocused
         * @return {?}
         */
        function (isFocused) {
            if (this._label) {
                this._label.focused = isFocused;
            }
            if (!isFocused) {
                this._group.onTouched();
            }
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(NgbRadio.prototype, "checked", {
        get: /**
         * @return {?}
         */
        function () { return this._checked; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(NgbRadio.prototype, "nameAttr", {
        get: /**
         * @return {?}
         */
        function () { return this.name || this._group.name; },
        enumerable: true,
        configurable: true
    });
    /**
     * @return {?}
     */
    NgbRadio.prototype.ngOnDestroy = /**
     * @return {?}
     */
    function () { this._group.unregister(this); };
    /**
     * @return {?}
     */
    NgbRadio.prototype.onChange = /**
     * @return {?}
     */
    function () { this._group.onRadioChange(this); };
    /**
     * @param {?} value
     * @return {?}
     */
    NgbRadio.prototype.updateValue = /**
     * @param {?} value
     * @return {?}
     */
    function (value) {
        this._checked = this.value === value;
        this._label.active = this._checked;
    };
    /**
     * @return {?}
     */
    NgbRadio.prototype.updateDisabled = /**
     * @return {?}
     */
    function () { this._label.disabled = this.disabled; };
    NgbRadio.decorators = [
        { type: Directive, args: [{
                    selector: '[ngbButton][type=radio]',
                    host: {
                        '[checked]': 'checked',
                        '[disabled]': 'disabled',
                        '[name]': 'nameAttr',
                        '(change)': 'onChange()',
                        '(focus)': 'focused = true',
                        '(blur)': 'focused = false'
                    }
                },] }
    ];
    /** @nocollapse */
    NgbRadio.ctorParameters = function () { return [
        { type: NgbRadioGroup },
        { type: NgbButtonLabel },
        { type: Renderer2 },
        { type: ElementRef }
    ]; };
    NgbRadio.propDecorators = {
        name: [{ type: Input }],
        value: [{ type: Input, args: ['value',] }],
        disabled: [{ type: Input, args: ['disabled',] }]
    };
    return NgbRadio;
}());
export { NgbRadio };
if (false) {
    /** @type {?} */
    NgbRadio.prototype._checked;
    /** @type {?} */
    NgbRadio.prototype._disabled;
    /** @type {?} */
    NgbRadio.prototype._value;
    /**
     * The name of the input. All inputs of a group should have the same name. If not specified,
     * the name of the enclosing group is used.
     * @type {?}
     */
    NgbRadio.prototype.name;
    /** @type {?} */
    NgbRadio.prototype._group;
    /** @type {?} */
    NgbRadio.prototype._label;
    /** @type {?} */
    NgbRadio.prototype._renderer;
    /** @type {?} */
    NgbRadio.prototype._element;
}
//# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoicmFkaW8uanMiLCJzb3VyY2VSb290Ijoibmc6Ly9AbmctYm9vdHN0cmFwL25nLWJvb3RzdHJhcC8iLCJzb3VyY2VzIjpbImJ1dHRvbnMvcmFkaW8udHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7OztBQUFBLE9BQU8sRUFBQyxTQUFTLEVBQUUsVUFBVSxFQUFFLFVBQVUsRUFBRSxLQUFLLEVBQWEsU0FBUyxFQUFDLE1BQU0sZUFBZSxDQUFDO0FBQzdGLE9BQU8sRUFBdUIsaUJBQWlCLEVBQUMsTUFBTSxnQkFBZ0IsQ0FBQztBQUV2RSxPQUFPLEVBQUMsY0FBYyxFQUFDLE1BQU0sU0FBUyxDQUFDOztJQUVqQyx3QkFBd0IsR0FBRztJQUMvQixPQUFPLEVBQUUsaUJBQWlCO0lBQzFCLFdBQVcsRUFBRSxVQUFVLENBQUMsY0FBTSxPQUFBLGFBQWEsRUFBYixDQUFhLENBQUM7SUFDNUMsS0FBSyxFQUFFLElBQUk7Q0FDWjs7SUFFRyxNQUFNLEdBQUcsQ0FBQzs7Ozs7QUFNZDtJQUFBO1FBRVUsWUFBTyxHQUFrQixJQUFJLEdBQUcsRUFBWSxDQUFDO1FBQzdDLFdBQU0sR0FBRyxJQUFJLENBQUM7Ozs7O1FBVWIsU0FBSSxHQUFHLGVBQWEsTUFBTSxFQUFJLENBQUM7UUFFeEMsYUFBUSxHQUFHLFVBQUMsQ0FBTSxJQUFNLENBQUMsQ0FBQztRQUMxQixjQUFTLEdBQUcsY0FBTyxDQUFDLENBQUM7SUE2QnZCLENBQUM7SUF2Q0Msc0JBQUksbUNBQVE7Ozs7UUFBWixjQUFpQixPQUFPLElBQUksQ0FBQyxTQUFTLENBQUMsQ0FBQyxDQUFDOzs7OztRQUN6QyxVQUFhLFVBQW1CLElBQUksSUFBSSxDQUFDLGdCQUFnQixDQUFDLFVBQVUsQ0FBQyxDQUFDLENBQUMsQ0FBQzs7O09BRC9COzs7OztJQVl6QyxxQ0FBYTs7OztJQUFiLFVBQWMsS0FBZTtRQUMzQixJQUFJLENBQUMsVUFBVSxDQUFDLEtBQUssQ0FBQyxLQUFLLENBQUMsQ0FBQztRQUM3QixJQUFJLENBQUMsUUFB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QVgsVUFBWSxLQUFLO1FBQ2YsSUFBSSxDQUFDLFFBQVEsR0FBRyxJQUFJLENBQUMsS0FBSyxLQUFLLEtBQUssQ0FBQztRQUNyQyxJQUFJLENBQUMsTUFBTSxDQUFDLE1BQU0sR0FBRyxJQUFJLENBQUMsUUFBUSxDQUFDO0lBQ3JDLENBQUM7Ozs7SUFFRCxpQ0FBYzs7O0lBQWQsY0FBbUIsSUFBSSxDQUFDLE1BQU0sQ0FBQyxRQUFRLEdBQUcsSUFBSSxDQUFDLFFBQVEsQ0FBQyxDQUFDLENBQUM7O2dCQTNFM0QsU0FBUyxTQUFDO29CQUNULFFBQVEsRUFBRSx5QkFBeUI7b0JBQ25DLElBQUksRUFBRTt3QkFDSixXQUFXLEVBQUUsU0FBUzt3QkFDdEIsWUFBWSxFQUFFLFVBQVU7d0JBQ3hCLFFBQVEsRUFBRSxVQUFVO3dCQUNwQixVQUFVLEVBQUUsWUFBWTt3QkFDeEIsU0FBUyxFQUFFLGdCQUFnQjt3QkFDM0IsUUFBUSxFQUFFLGlCQUFpQjtxQkFDNUI7aUJBQ0Y7Ozs7Z0JBa0RxQixhQUFhO2dCQTdIM0IsY0FBYztnQkFIdUMsU0FBUztnQkFBbkQsVUFBVTs7O3VCQXdGMUIsS0FBSzt3QkFLTCxLQUFLLFNBQUMsT0FBTzsyQkFXYixLQUFLLFNBQUMsVUFBVTs7SUF3Q25CLGVBQUM7Q0FBQSxBQTVFRCxJQTRFQztTQWpFWSxRQUFROzs7SUFDbkIsNEJBQTBCOztJQUMxQiw2QkFBMkI7O0lBQzNCLDBCQUEyQjs7Ozs7O0lBTTNCLHdCQUFzQjs7SUF3Q2xCLDBCQUE2Qjs7SUFBRSwwQkFBOEI7O0lBQUUsNkJBQTRCOztJQUMzRiw0QkFBOEMiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQge0RpcmVjdGl2ZSwgRWxlbWVudFJlZiwgZm9yd2FyZFJlZiwgSW5wdXQsIE9uRGVzdHJveSwgUmVuZGVyZXIyfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7Q29udHJvbFZhbHVlQWNjZXNzb3IsIE5HX1ZBTFVFX0FDQ0VTU09SfSBmcm9tICdAYW5ndWxhci9mb3Jtcyc7XG5cbmltcG9ydCB7TmdiQnV0dG9uTGFiZWx9IGZyb20gJy4vbGFiZWwnO1xuXG5jb25zdCBOR0JfUkFESU9fVkFMVUVfQUNDRVNTT1IgPSB7XG4gIHByb3ZpZGU6IE5HX1ZBTFVFX0FDQ0VTU09SLFxuICB1c2VFeGlzdGluZzogZm9yd2FyZFJlZigoKSA9PiBOZ2JSYWRpb0dyb3VwKSxcbiAgbXVsdGk6IHRydWVcbn07XG5cbmxldCBuZXh0SWQgPSAwO1xuXG4vKipcbiAqIEVhc2lseSBjcmVhdGUgQm9vdHN0cmFwLXN0eWxlIHJhZGlvIGJ1dHRvbnMuIEEgdmFsdWUgb2YgYSBzZWxlY3RlZCBidXR0b24gaXMgYm91bmQgdG8gYSB2YXJpYWJsZVxuICogc3BlY2lmaWVkIHZpYSBuZ01vZGVsLlxuICovXG5ARGlyZWN0aXZlKHtzZWxlY3RvcjogJ1tuZ2JSYWRpb0dyb3VwXScsIGhvc3Q6IHsncm9sZSc6ICdncm91cCd9LCBwcm92aWRlcnM6IFtOR0JfUkFESU9fVkFMVUVfQUNDRVNTT1JdfSlcbmV4cG9ydCBjbGFzcyBOZ2JSYWRpb0dyb3VwIGltcGxlbWVudHMgQ29udHJvbFZhbHVlQWNjZXNzb3Ige1xuICBwcml2YXRlIF9yYWRpb3M6IFNldDxOZ2JSYWRpbz4gPSBuZXcgU2V0PE5nYlJhZGlvPigpO1xuICBwcml2YXRlIF92YWx1ZSA9IG51bGw7XG4gIHByaXZhdGUgX2Rpc2FibGVkOiBib29sZWFuO1xuXG4gIGdldCBkaXNhYmxlZCgpIHsgcmV0dXJuIHRoaXMuX2Rpc2FibGVkOyB9XG4gIHNldCBkaXNhYmxlZChpc0Rpc2FibGVkOiBib29sZWFuKSB7IHRoaXMuc2V0RGlzYWJsZWRTdGF0ZShpc0Rpc2FibGVkKTsgfVxuXG4gIC8qKlxuICAgKiBUaGUgbmFtZSBvZiB0aGUgZ3JvdXAuIFVubGVzcyBlbmNsb3NlZCBpbnB1dHMgc3BlY2lmeSBhIG5hbWUsIHRoaXMgbmFtZSBpcyB1c2VkIGFzIHRoZSBuYW1lIG9mIHRoZVxuICAgKiBlbmNsb3NlZCBpbnB1dHMuIElmIG5vdCBzcGVjaWZpZWQsIGEgbmFtZSBpcyBnZW5lcmF0ZWQgYXV0b21hdGljYWxseS5cbiAgICovXG4gIEBJbnB1dCgpIG5hbWUgPSBgbmdiLXJhZGlvLSR7bmV4dElkKyt9YDtcblxuICBvbkNoYW5nZSA9IChfOiBhbnkpID0+IHt9O1xuICBvblRvdWNoZWQgPSAoKSA9PiB7fTtcblxuICBvblJhZGlvQ2hhbmdlKHJhZGlvOiBOZ2JSYWRpbykge1xuICAgIHRoaXMud3JpdGVWYWx1ZShyYWRpby52YWx1ZSk7XG4gICAgdGhpcy5vbkNoYW5nZShyYWRpby52YWx1ZSk7XG4gIH1cblxuICBvblJhZGlvVmFsdWVVcGRhdGUoKSB7IHRoaXMuX3VwZGF0ZVJhZGlvc1ZhbHVlKCk7IH1cblxuICByZWdpc3RlcihyYWRpbzogTmdiUmFkaW8pIHsgdGhpcy5fcmFkaW9zLmFkZChyYWRpbyk7IH1cblxuICByZWdpc3Rlck9uQ2hhbmdlKGZuOiAodmFsdWU6IGFueSkgPT4gYW55KTogdm9pZCB7IHRoaXMub25DaGFuZ2UgPSBmbjsgfVxuXG4gIHJlZ2lzdGVyT25Ub3VjaGVkKGZuOiAoKSA9PiBhbnkpOiB2b2lkIHsgdGhpcy5vblRvdWNoZWQgPSBmbjsgfVxuXG4gIHNldERpc2FibGVkU3RhdGUoaXNEaXNhYmxlZDogYm9vbGVhbik6IHZvaWQge1xuICAgIHRoaXMuX2Rpc2FibGVkID0gaXNEaXNhYmxlZDtcbiAgICB0aGlzLl91cGRhdGVSYWRpb3NEaXNhYmxlZCgpO1xuICB9XG5cbiAgdW5yZWdpc3RlcihyYWRpbzogTmdiUmFkaW8pIHsgdGhpcy5fcmFkaW9zLmRlbGV0ZShyYWRpbyk7IH1cblxuICB3cml0ZVZhbHVlKHZhbHVlKSB7XG4gICAgdGhpcy5fdmFsdWUgPSB2YWx1ZTtcbiAgICB0aGlzLl91cGRhdGVSYWRpb3NWYWx1ZSgpO1xuICB9XG5cbiAgcHJpdmF0ZSBfdXBkYXRlUmFkaW9zVmFsdWUoKSB7IHRoaXMuX3JhZGlvcy5mb3JFYWNoKChyYWRpbykgPT4gcmFkaW8udXBkYXRlVmFsdWUodGhpcy5fdmFsdWUpKTsgfVxuICBwcml2YXRlIF91cGRhdGVSYWRpb3NEaXNhYmxlZCgpIHsgdGhpcy5fcmFkaW9zLmZvckVhY2goKHJhZGlvKSA9PiByYWRpby51cGRhdGVEaXNhYmxlZCgpKTsgfVxufVxuXG5cbi8qKlxuICogTWFya3MgYW4gaW5wdXQgb2YgdHlwZSBcInJhZGlvXCIgYXMgcGFydCBvZiB0aGUgTmdiUmFkaW9Hcm91cC5cbiAqL1xuQERpcmVjdGl2ZSh7XG4gIHNlbGVjdG9yOiAnW25nYkJ1dHRvbl1bdHlwZT1yYWRpb10nLFxuICBob3N0OiB7XG4gICAgJ1tjaGVja2VkXSc6ICdjaGVja2VkJyxcbiAgICAnW2Rpc2FibGVkXSc6ICdkaXNhYmxlZCcsXG4gICAgJ1tuYW1lXSc6ICduYW1lQXR0cicsXG4gICAgJyhjaGFuZ2UpJzogJ29uQ2hhbmdlKCknLFxuICAgICcoZm9jdXMpJzogJ2ZvY3VzZWQgPSB0cnVlJyxcbiAgICAnKGJsdXIpJzogJ2ZvY3VzZWQgPSBmYWxzZSdcbiAgfVxufSlcbmV4cG9ydCBjbGFzcyBOZ2JSYWRpbyBpbXBsZW1lbnRzIE9uRGVzdHJveSB7XG4gIHByaXZhdGUgX2NoZWNrZWQ6IGJvb2xlYW47XG4gIHByaXZhdGUgX2Rpc2FibGVkOiBib29sZWFuO1xuICBwcml2YXRlIF92YWx1ZTogYW55ID0gbnVsbDtcblxuICAvKipcbiAgICogVGhlIG5hbWUgb2YgdGhlIGlucHV0LiBBbGwgaW5wdXRzIG9mIGEgZ3JvdXAgc2hvdWxkIGhhdmUgdGhlIHNhbWUgbmFtZS4gSWYgbm90IHNwZWNpZmllZCxcbiAgICogdGhlIG5hbWUgb2YgdGhlIGVuY2xvc2luZyBncm91cCBpcyB1c2VkLlxuICAgKi9cbiAgQElucHV0KCkgbmFtZTogc3RyaW5nO1xuXG4gIC8qKlxuICAgKiBZb3UgY2FuIHNwZWNpZnkgbW9kZWwgdmFsdWUgb2YgYSBnaXZlbiByYWRpbyBieSBiaW5kaW5nIHRvIHRoZSB2YWx1ZSBwcm9wZXJ0eS5cbiAgICovXG4gIEBJbnB1dCgndmFsdWUnKVxuICBzZXQgdmFsdWUodmFsdWU6IGFueSkge1xuICAgIHRoaXMuX3ZhbHVlID0gdmFsdWU7XG4gICAgY29uc3Qgc3RyaW5nVmFsdWUgPSB2YWx1ZSA/IHZhbHVlLnRvU3RyaW5nKCkgOiAnJztcbiAgICB0aGlzLl9yZW5kZXJlci5zZXRQcm9wZXJ0eSh0aGlzLl9lbGVtZW50Lm5hdGl2ZUVsZW1lbnQsICd2YWx1ZScsIHN0cmluZ1ZhbHVlKTtcbiAgICB0aGlzLl9ncm91cC5vblJhZGlvVmFsdWVVcGRhdGUoKTtcbiAgfVxuXG4gIC8qKlxuICAgKiBBIGZsYWcgaW5kaWNhdGluZyBpZiBhIGdpdmVuIHJhZGlvIGJ1dHRvbiBpcyBkaXNhYmxlZC5cbiAgICovXG4gIEBJbnB1dCgnZGlzYWJsZWQnKVxuICBzZXQgZGlzYWJsZWQoaXNEaXNhYmxlZDogYm9vbGVhbikge1xuICAgIHRoaXMuX2Rpc2FibGVkID0gaXNEaXNhYmxlZCAhPT0gZmFsc2U7XG4gICAgdGhpcy51cGRhdGVEaXNhYmxlZCgpO1xuICB9XG5cbiAgc2V0IGZvY3VzZWQoaXNGb2N1c2VkOiBib29sZWFuKSB7XG4gICAgaWYgKHRoaXMuX2xhYmVsKSB7XG4gICAgICB0aGlzLl9sYWJlbC5mb2N1c2VkID0gaXNGb2N1c2VkO1xuICAgIH1cbiAgICBpZiAoIWlzRm9jdXNlZCkge1xuICAgICAgdGhpcy5fZ3JvdXAub25Ub3VjaGVkKCk7XG4gICAgfVxuICB9XG5cbiAgZ2V0IGNoZWNrZWQoKSB7IHJldHVybiB0aGlzLl9jaGVja2VkOyB9XG5cbiAgZ2V0IGRpc2FibGVkKCkgeyByZXR1cm4gdGhpcy5fZ3JvdXAuZGlzYWJsZWQgfHwgdGhpcy5fZGlzYWJsZWQ7IH1cblxuICBnZXQgdmFsdWUoKSB7IHJldHVybiB0aGlzLl92YWx1ZTsgfVxuXG4gIGdldCBuYW1lQXR0cigpIHsgcmV0dXJuIHRoaXMubmFtZSB8fCB0aGlzLl9ncm91cC5uYW1lOyB9XG5cbiAgY29uc3RydWN0b3IoXG4gICAgICBwcml2YXRlIF9ncm91cDogTmdiUmFkaW9Hcm91cCwgcHJpdmF0ZSBfbGFiZWw6IE5nYkJ1dHRvbkxhYmVsLCBwcml2YXRlIF9yZW5kZXJlcjogUmVuZGVyZXIyLFxuICAgICAgcHJpdmF0ZSBfZWxlbWVudDogRWxlbWVudFJlZjxIVE1MSW5wdXRFbGVtZW50Pikge1xuICAgIHRoaXMuX2dyb3VwLnJlZ2lzdGVyKHRoaXMpO1xuICAgIHRoaXMudXBkYXRlRGlzYWJsZWQoKTtcbiAgfVxuXG4gIG5nT25EZXN0cm95KCkgeyB0aGlzLl9ncm91cC51bnJlZ2lzdGVyKHRoaXMpOyB9XG5cbiAgb25DaGFuZ2UoKSB7IHRoaXMuX2dyb3VwLm9uUmFkaW9DaGFuZ2UodGhpcyk7IH1cblxuICB1cGRhdGVWYWx1ZSh2YWx1ZSkge1xuICAgIHRoaXMuX2NoZWNrZWQgPSB0aGlzLnZhbHVlID09PSB2YWx1ZTtcbiAgICB0aGlzLl9sYWJlbC5hY3RpdmUgPSB0aGlzLl9jaGVja2VkO1xuICB9XG5cbiAgdXBkYXRlRGlzYWJsZWQoKSB7IHRoaXMuX2xhYmVsLmRpc2FibGVkID0gdGhpcy5kaXNhYmxlZDsgfVxufVxuIl19