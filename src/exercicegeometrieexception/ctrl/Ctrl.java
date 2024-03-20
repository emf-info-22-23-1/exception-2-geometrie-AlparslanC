package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        try {
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        } catch (NumberFormatException ex) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du cercle (" + value + " invalide)");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        double valueAreaDouble = 0.0;
        try{
        valueAreaDouble = Double.parseDouble(valueArea);
        }catch(Exception ex){
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle (" + valueArea + " invalide)");
        }
        double valueLongueurDouble = 0.0;
        try{
        valueLongueurDouble = Double.parseDouble(valueLongueur);
        } catch (Exception ex){
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle (" + ex + " invalide)");
        }
        refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
