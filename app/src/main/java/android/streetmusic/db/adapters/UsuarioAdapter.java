package android.streetmusic.db.adapters;

import android.streetmusic.R;
import android.streetmusic.db.entities.Usuario;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioHolder > {

    private List<Usuario> usuarios = new ArrayList<>();

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);
        return new UsuarioHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioHolder usuarioHolder, int i) {
        Usuario usuarioAtual = usuarios.get(i);
        usuarioHolder.textViewEmail.setText(usuarioAtual.getEmail());
        usuarioHolder.textViewUid.setText(String.valueOf(usuarioAtual.getUid()));
        usuarioHolder.textViewNome.setText(usuarioAtual.getNome());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        notifyDataSetChanged();
    }

    class UsuarioHolder extends RecyclerView.ViewHolder {
        private TextView textViewNome;
        private TextView textViewUid;
        private TextView textViewEmail;

        public UsuarioHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.text_view_nome);
            textViewUid = itemView.findViewById(R.id.text_view_uid);
            textViewEmail = itemView.findViewById(R.id.text_view_email);
        }
    }
}
