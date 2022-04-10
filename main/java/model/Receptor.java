package model;

public class Receptor {
	
	private String id;
	
	private String nome;
	
	private String email;
        
        private String fone;
        
        private String horario;
        
        private String datas;
        
        private String vaga;

        public Receptor() {
		super();
	}
	public Receptor(String id, String nome, String fone, String email, String horario, String datas, String vaga) {
		super();
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
                this.horario = horario;
                this.datas = datas;
                this.vaga = vaga;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

        public String getHorario() {
        return horario;
        }

        public void setHorario(String horario) {
        this.horario = horario;
        }
        
        public String getDatas() {
        return datas;
        }

        public void setDatas(String datas) {
        this.datas = datas;
        }

        public String getVaga() {
        return vaga;
        }

        public void setVaga(String vaga) {
        this.vaga = vaga;
        }
}