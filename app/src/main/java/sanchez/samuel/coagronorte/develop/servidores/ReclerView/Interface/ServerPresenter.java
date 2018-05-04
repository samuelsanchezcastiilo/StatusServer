package sanchez.samuel.coagronorte.develop.servidores.ReclerView.Interface;

import java.util.List;

import sanchez.samuel.coagronorte.develop.servidores.ReclerView.Model.Server;

public interface ServerPresenter {
 void  initRecycler(List<Server> servers);
 void  errorRecycler(String error);


}
