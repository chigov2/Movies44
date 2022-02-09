package techmarket.uno.movies44;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.PosterViewHolder> {

    private List<PosterSmall> posterSmalls;

    public PosterAdapter() {
        posterSmalls = new ArrayList<>();
    }
    public List<PosterSmall> getPosterSmalls() {
        return posterSmalls;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPosterSmalls(List<PosterSmall> posterSmalls) {
        this.posterSmalls = posterSmalls;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.poster_item,parent,false);
        return new PosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosterViewHolder holder, int position) {
        //holder.imageViewPoster.setImageResource(posterSmalls.get(position).getImageViewPoster());
    }

    @Override
    public int getItemCount() {
        return posterSmalls.size();
    }

    class PosterViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewPoster;

        public PosterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
        }
    }
}
