package model;

public class Doacao {

        private int id_doacao;
        private Double valor;
        private int fk_Doadores_Id_doadores;
        private int fk_Projetos_Id_projeto;
        
        public int getId_doacao() {
            return id_doacao;
        }
        
        public void setId_doacao(int id_doacao) {
            this.id_doacao = id_doacao;
        }
        
        public Double getValor() {
            return valor;
        }
        
        public void setValor(Double valor) {
            this.valor = valor;
        }
        
        public int getFk_Doadores_Id_doadores() {
            return fk_Doadores_Id_doadores;
        }
        
        public void setFk_Doadores_Id_doadores(int fk_Doadores_Id_doadores) {
            this.fk_Doadores_Id_doadores = fk_Doadores_Id_doadores;
        }
        
        public int getFk_Projetos_Id_projeto() {
            return fk_Projetos_Id_projeto;
        }
        
        public void setFk_Projetos_Id_projeto(int fk_Projetos_Id_projeto) {
            this.fk_Projetos_Id_projeto = fk_Projetos_Id_projeto;
        }
              
}
