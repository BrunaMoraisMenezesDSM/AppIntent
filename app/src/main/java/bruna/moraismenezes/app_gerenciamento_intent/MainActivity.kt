package bruna.moraismenezes.app_gerenciamento_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //declarando variáveis
    lateinit var btContato: Button
    lateinit var btLocal: Button
    lateinit var btSite: Button
    lateinit var btNovaTela: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btContato = findViewById(R.id.btContato)
        btLocal = findViewById(R.id.btLocal)
        btSite = findViewById(R.id.btSite)
        btNovaTela = findViewById(R.id.btNovaTela)

        btContato.setOnClickListener{ exibirContatos() }
        btLocal.setOnClickListener{ exibirLocal() }
        btSite.setOnClickListener{ exibirSite() }
        btNovaTela.setOnClickListener{ exibirNovaTela() }
    }

    private fun exibirContatos() {
        val dados = Uri.parse("content://contacts/people/1") //pesquisar o contato 1 (ordem contato cadastrado), senão, tirar o /1
        val intent: Intent  = Intent(Intent.ACTION_VIEW, dados)
        startActivity(intent)
    }

    private fun exibirLocal() {
        val dados = Uri.parse("geo: -23.663590790464198, -46.46012480333216?z=19")
        val intent: Intent  = Intent(Intent.ACTION_VIEW, dados)
        startActivity(intent)
    }

    private fun exibirSite() {
        val dados = Uri.parse("http://www.google.com")
        val intent: Intent  = Intent(Intent.ACTION_VIEW, dados)
        startActivity(intent)
    }

    private fun exibirNovaTela() {
        val intent: Intent  = Intent(baseContext, Tela2Activity::class.java) //mostrar para o android e expor a estrutura da classe
        startActivity(intent)
    }
}