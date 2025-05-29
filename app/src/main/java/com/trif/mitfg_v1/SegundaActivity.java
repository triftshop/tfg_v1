package com.trif.mitfg_v1;

/**
 * Segunda actividad - COMPLETAMENTE NUEVA
 * Demuestra lo fácil que es crear nuevas pantallas
 */
public class SegundaActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_segunda;
    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();

        // Configura botón de regreso
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.segunda_title);
        }
    }

    @Override
    protected void setupUI() {
        super.setupUI();

        // Aquí puedes añadir cualquier lógica específica de esta pantalla
        // Por ejemplo, configurar listeners, inicializar datos, etc.
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