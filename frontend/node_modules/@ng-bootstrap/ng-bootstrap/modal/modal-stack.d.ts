import { ApplicationRef, ComponentFactoryResolver, Injector, RendererFactory2 } from '@angular/core';
import { ScrollBar } from '../util/scrollbar';
import { NgbModalRef } from './modal-ref';
export declare class NgbModalStack {
    private _applicationRef;
    private _injector;
    private _document;
    private _scrollBar;
    private _rendererFactory;
    private _windowAttributes;
    private _backdropAttributes;
    private _modalRefs;
    private _windowCmpts;
    private _activeWindowCmptHasChanged;
    constructor(_applicationRef: ApplicationRef, _injector: Injector, _document: any, _scrollBar: ScrollBar, _rendererFactory: RendererFactory2);
    open(moduleCFR: ComponentFactoryResolver, contentInjector: Injector, content: any, options: any): NgbModalRef;
    dismissAll(reason?: any): void;
    hasOpenModals(): boolean;
    private _attachBackdrop;
    private _attachWindowComponent;
    private _applyWindowOptions;
    private _applyBackdropOptions;
    private _getContentRef;
    private _createFromTemplateRef;
    private _createFromString;
    private _createFromComponent;
    private _registerModalRef;
    private _registerWindowCmpt;
}
