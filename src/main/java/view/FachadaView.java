package view;

public class FachadaView {
	private Ventana view;
	private Mensaje msj;

	public FachadaView() {
		view = new Ventana();
		msj = new Mensaje();
	}

	public Mensaje getMsj() {
		return msj;
	}

	public void setMsj(Mensaje msj) {
		this.msj = msj;
	}

	public Ventana getView() {
		return view;
	}

	public void setView(Ventana view) {
		this.view = view;
	}

}
