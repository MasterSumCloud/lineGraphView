package linegraph.y.p.summer.linegraphview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LineGraphView mLineGraphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLineGraphView = (LineGraphView) findViewById(R.id.line_graph_view);
        
    }
}
