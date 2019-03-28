package br.progep.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.progep.dao.FabricanteDAO;
import br.progep.domain.Fabricante;

@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			
			FabricanteDAO dao = new FabricanteDAO();
			
			Fabricante fabricante = dao.buscaPorCodigo(codigo);
			
			return fabricante;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Fabricante fabricante = (Fabricante) objeto;
			
			String codigo = fabricante.getCodigo().toString();
			
			return codigo;
		} catch (RuntimeException ex) {
			return null;
		}
	}

}
