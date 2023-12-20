package com.example.a07ex07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val r = findViewById<RecyclerView>(R.id.rv)
        r.layoutManager = LinearLayoutManager(this)

        // definindo o array de produtos
        val arr = ArrayList<Produto>()
        // adicionando dois primeiros produtos
        arr.add(Produto(android.R.drawable.ic_menu_camera, "Máquina fotográfica", "R$ 100,00"))
        arr.add(Produto(android.R.drawable.ic_menu_call, "Telefone analógico", "R$ 12,00"))
        // adicionando os demais produtos fictícios
        for (i in 3 .. 99)
            arr.add(Produto(android.R.drawable.ic_menu_edit,"Produto $i", "R$ $i,99"))
        // definindo o adapter
        val adapter = CustomAdapter(arr)
        r.adapter = adapter

        // Encontrar o FloatingActionButton
        val fabTop = findViewById<FloatingActionButton>(R.id.fab_top)

        // Método criado para que ao ser clicado volta ao topo RecyclerView de volta para o topo
        fabTop.setOnClickListener {
            r.scrollToPosition(0)

            // Chama a função 'exibirToast' para exibir um Toast
            exibirToast(this, "Voltou ao topo!")
        }


    }
}

// Função para exibir um Toast na tela
fun exibirToast(context: Context, mensagem: String) {
    Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
}
