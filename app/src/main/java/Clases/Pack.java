package Clases;

public class Pack {
    private String nombrePack;
    private int precioPack;

    public Pack(String pack){
        if(pack.contains("Pack1")) {
            nombrePack = "Pack 1";
            precioPack = 150000;
        }
        if(pack.contains("Pack2")) {
            nombrePack = "Pack 2";
            precioPack = 80000;
        }
    }

    public String getNombrePack(){
        return nombrePack;
    }

    public int getPrecioPack(){
        return precioPack;
    }

    public void setPrecioPack(int nuevoPrecio){
        precioPack = nuevoPrecio;
    }
}
