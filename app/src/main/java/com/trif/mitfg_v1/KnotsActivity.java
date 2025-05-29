package com.trif.mitfg_v1;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class KnotsActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_knots;
    }

    @Override
    protected void setupToolbar() {
        super.setupToolbar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.knots_title);
        }
    }

    @Override
    protected void setupUI() {
        super.setupUI();
        setupKnotsList();
    }

    private void setupKnotsList() {
        RecyclerView recyclerView = findViewById(R.id.recyclerKnots);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<KnotItem> knots = getKnotsList();
        KnotsAdapter adapter = new KnotsAdapter(knots, knot -> {
            android.content.Intent intent = new android.content.Intent(this, KnotTutorialActivity.class);
            intent.putExtra("knot_id", knot.getId());
            intent.putExtra("knot_name", knot.getName());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        recyclerView.setAdapter(adapter);
    }

    private List<KnotItem> getKnotsList() {
        List<KnotItem> knots = new ArrayList<>();

        knots.add(new KnotItem(1, getString(R.string.knot_1_name), getString(R.string.knot_1_description), "knot_1_icon"));
        knots.add(new KnotItem(2, getString(R.string.knot_2_name), getString(R.string.knot_2_description), "knot_2_icon"));
        knots.add(new KnotItem(3, getString(R.string.knot_3_name), getString(R.string.knot_3_description), "knot_3_icon"));

        return knots;
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