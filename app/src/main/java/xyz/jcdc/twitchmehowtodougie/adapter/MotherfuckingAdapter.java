package xyz.jcdc.twitchmehowtodougie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import xyz.jcdc.twitchmehowtodougie.R;

/**
 * Created by jcdc on 11/8/16.
 */

public class MotherfuckingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int HEADER_VIEW = 0;
    private final static int CONTENT_VIEW = 1;

    private Context context;
    private ArrayList<Objects> items;

    public MotherfuckingAdapter(Context context, ArrayList<Objects> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case HEADER_VIEW:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_livestream, parent, false);
                return new LiveStreamView(v);
            default: CONTENT_VIEW:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_items, parent, false);
                return new VideosView(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == HEADER_VIEW) {
            LiveStreamView motherfuckingViewHolder = (LiveStreamView) holder;

            motherfuckingViewHolder.webView.setWebViewClient(new WebViewClient());
            motherfuckingViewHolder.webView.setInitialScale(1);
            motherfuckingViewHolder.webView.getSettings().setJavaScriptEnabled(true);
            motherfuckingViewHolder.webView.getSettings().setLoadWithOverviewMode(true);
            motherfuckingViewHolder.webView.getSettings().setUseWideViewPort(true);
            motherfuckingViewHolder.webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            motherfuckingViewHolder.webView.setScrollbarFadingEnabled(false);
            motherfuckingViewHolder.webView.loadUrl("http://johnchrisdc.me/twitch/channel/johnchrisdc");

            Log.d("MotherfuckingAdapter", "Hello");
        } else {
            Log.d("MotherfuckingAdapter", "Hi");
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 5;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return HEADER_VIEW;
            default:
                return CONTENT_VIEW;
        }
    }

    public class LiveStreamView extends RecyclerView.ViewHolder {

        private WebView webView;

        public LiveStreamView(View itemView) {
            super(itemView);
            webView = (WebView) itemView.findViewById(R.id.webview);
        }
    }

    public class VideosView extends RecyclerView.ViewHolder {

        private TextView textView;

        public VideosView(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
