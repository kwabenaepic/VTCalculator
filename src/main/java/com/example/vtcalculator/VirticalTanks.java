package com.example.vtcalculator;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VirticalTanks {


    public String getDip() {
        return dip.get();
    }

    public StringProperty dipProperty() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip.set(dip);
    }

    private final StringProperty dip;

    public String getLitres() {
        return litres.get();
    }

    public StringProperty litresProperty() {
        return litres;
    }

    public void setLitres(String litres) {
        this.litres.set(litres);
    }

    private final StringProperty litres;

    public VirticalTanks() {
        this.dip = new SimpleStringProperty();
        this.litres = new SimpleStringProperty();
    }
}
//    private void getVTDipVolume() {
//        for (Map.Entry<String,String> entry : vtDipVolume.entrySet())
//            if (entry.getKey().equals(enterDip.getText())){
//
//                vtLitres = Integer.parseInt(entry.getValue());
//                avgLitres = 1;
//                System.out.println("Key = " +vtLitres);
//            }else {
//                if (entry.getKey().substring(0, 3).contains(enterDip.getText().subSequence(0, 3))) {
//                    vtLitres = Integer.parseInt(entry.getValue());
//
//                    System.out.println("Key = " + entry.getKey() +
//                            ", Value = " + entry.getValue());
//                }
//            }
//    }

//    private void getVTDipVolume() {
//        for (Map.Entry<String,String> entry : vtDipVolume.entrySet())
//            if (entry.getKey().equals(enterDip.getText())){
//
//                vtLitres = Integer.parseInt(entry.getValue());
//                avgLitres = 1;
//                System.out.println("Key = " +vtLitres);
//            }else if (entry.getKey().substring(0, 3).contains(enterDip.getText().subSequence(0, 3))) {
//                vtLitres = Integer.parseInt(entry.getValue());
//
//                System.out.println("Key = " + entry.getKey() +
//                        ", Value = " + entry.getValue());
//            }else{
//                if (entry.getKey().substring(0, 4).contains(enterDip.getText().subSequence(0, 4))) {
//                    vtLitres = Integer.parseInt(entry.getValue());
//
//                    System.out.println("Key = " + entry.getKey() +
//                            ", Value = " + entry.getValue());
//                }
//            }
//
//    }
