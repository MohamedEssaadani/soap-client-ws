import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stubws = new BanqueWS().getBanqueServicePort();
        System.out.println(stubws.conversionEuroToDH(300));
        Compte compte = stubws.getCompte("MM93");
        System.out.println("*********** Détail d'un compte ************");
        System.out.println("Compte Code: "+compte.getCode());
        System.out.println("Compte Solde:"+compte.getSolde());
        System.out.println("Compte Date creation: "+compte.getDateCreation().toString());

        System.out.println("*********** Liste des comptes ************");
        List<Compte> compteList = stubws.getComptes();
        compteList.forEach(cpt -> {
            System.out.println("Détail du compte: "+cpt.getCode());
            System.out.println("Compte Code: "+cpt.getCode());
            System.out.println("Compte Solde:"+cpt.getSolde());
            System.out.println("Compte Date creation: "+cpt.getDateCreation().toString());
        });



    }
}
