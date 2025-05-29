package com.trif.mitfg_v1;

/**
 * Primera actividad simplificada
 * Solo define el layout y la navegación de regreso
 */
public class PrimeraActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_primera;
    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();

        // Configura botón de regreso
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.primera_title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finishWithTransition();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}