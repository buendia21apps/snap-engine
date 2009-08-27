package org.esa.beam.gpf.common.reproject.ui;

import org.esa.beam.framework.datamodel.Product;
import org.esa.beam.framework.gpf.GPF;
import org.esa.beam.framework.gpf.ui.SingleTargetProductDialog;
import org.esa.beam.framework.ui.AppContext;

import java.util.Map;

/**
 * User: Marco
 * Date: 16.08.2009
 */
public class ReprojectionDialog extends SingleTargetProductDialog {

    private ReprojectionForm form;

    public ReprojectionDialog(AppContext appContext) {
        super(appContext, "Reproject", "reproject");
        form = new ReprojectionForm(getTargetProductSelector(), appContext);
    }

    @Override
    protected Product createTargetProduct() throws Exception {
        final Map<String, Product> productMap = form.getProductMap();
        final Map<String, Object> parameterMap = form.getParameterMap();
        return GPF.createProduct("Reproject", parameterMap, productMap);
    }

    @Override
    public int show() {
        form.prepareShow();
        setContent(form);
        return super.show();
    }

    @Override
    public void hide() {
        form.prepareHide();
        super.hide();
    }

}
