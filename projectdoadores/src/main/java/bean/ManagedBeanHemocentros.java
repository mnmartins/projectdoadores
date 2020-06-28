package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import dao.DAO;
import model.Cidade;
import model.Estado;
import model.Hemocentro;

@ManagedBean (name = "estadoBean")
@ViewScoped
public class ManagedBeanHemocentros {
	private DAO daoGenerico = new DAO<>();
	private List<SelectItem> list = new ArrayList<SelectItem>();
	private List<SelectItem> listCidades = new ArrayList<SelectItem>();
	private Cidade cidade = new Cidade();
	
	private List<Estado> estados;
	private List<SelectItem> cidades;
	private List<Hemocentro> hemocentros;
	private Hemocentro hemocentro = new Hemocentro();
	
	
	public List<SelectItem> getEstados() {
		estados = daoGenerico.listarTodasEntidades(Estado.class);
		
		for (Estado e : estados) {
			list.add(new SelectItem(e.getId(), e.getUf()));
		}
		return list;
	}
	/**public List<SelectItem> getEstados() {
		estados = iDaoPessoa.listaEstados();
		return estados;
	}*/
	
	public void carregaCidades(AjaxBehaviorEvent event) {
		
		String estadoId = (String) ((HtmlSelectOneMenu) event.getSource()).getValue();

		if (estadoId != null) {
			Estado estado = (Estado) daoGenerico.pesquisarEntidadeById(Long.parseLong(estadoId), Estado.class);
			carregaHemocentrosEstado(estado);
			
			cidade.setEstado(estado);

			List<Cidade> cidades = daoGenerico.pesquisarEntidadeByUf(estado.getId().intValue(), Cidade.class);
			
			List<SelectItem> selectItemsCidade = new ArrayList<SelectItem>();

			for (Cidade cidade : cidades) {
				selectItemsCidade.add(new SelectItem(cidade.getId(), cidade.getNome()));
			}

			setCidades(selectItemsCidade);
			
		}
		
	}

	private void carregaHemocentrosEstado(Estado estado) {
		if (estado != null) {
			hemocentro.setEstado(estado);

			hemocentros = daoGenerico.pesquisarHemocentroByUf(estado.getId(), Hemocentro.class);
		}
	}
	
	//TODO corrigir listener
	private void carregaHemocentrosCidade(AjaxBehaviorEvent event) {
		String cidadeId = (String) ((HtmlSelectOneMenu) event.getSource()).getValue();
		
		if (cidadeId != null) {
			Cidade cidade = (Cidade) daoGenerico.pesquisarEntidadeById(Long.parseLong(cidadeId), Cidade.class);
			
			//hemocentro.setEstado(estado);
			hemocentro.setCidade(cidade);

			hemocentros = daoGenerico.pesquisarHemocentroByUfCidade(cidade.getEstado().getId(), cidade.getId(), Hemocentro.class);
		}
	}
		
	public List<SelectItem> getCidades() {
		return cidades;
	}

	public void setCidades(List<SelectItem> cidades) {
		this.cidades = cidades;
	}
	
	public void setHemocentro(Hemocentro hemocentro) {
		this.hemocentro = hemocentro;
	}
	
	public Hemocentro getHemocentro() {
		return hemocentro;
	}
	
	public void setHemocentros(List<Hemocentro> hemocentros) {
		this.hemocentros = hemocentros;
	}
	
	public List<Hemocentro> getHemocentros() {
		return hemocentros;
	}
}
