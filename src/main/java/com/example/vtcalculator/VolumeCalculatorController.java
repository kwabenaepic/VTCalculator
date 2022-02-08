package com.example.vtcalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class VolumeCalculatorController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> cBselectTank;
    @FXML
    private TextField enterDip;
    @FXML
    private TextField tfResult;


    private ObservableList<String> selectTank;
    private static Connection conn = ConnectionManager.getConnection();
    Map<String, String> vtAverages = new HashMap<>();
    Map<String, String> vtDipVolume = new HashMap<>();

    Map<String, String> vt4Averages = new HashMap<>();
    Map<String, String> vt4DipVolume = new HashMap<>();

    Map<String, String> vt3Averages = new HashMap<>();
    Map<String, String> vt3DipVolume = new HashMap<>();

    Map<String, String> vt1Averages = new HashMap<>();
    Map<String, String> vt1DipVolume = new HashMap<>();

    Map<String, String> vt2Averages = new HashMap<>();
    Map<String, String> vt2DipVolume = new HashMap<>();
    int vtLitres = 0;
    int avgLitres = 0;
    char last;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//vt4DipVolume.putAll(VirticalTanksManager.getDipVolume());

        selectTank = FXCollections.observableArrayList();
        selectTank.add("Vertical Tank 1");
        selectTank.add("Vertical Tank 2");
        selectTank.add("Vertical Tank 3");
        selectTank.add("Vertical Tank 4");
        cBselectTank.setItems(selectTank);

        vt4Averages = FXCollections.observableHashMap();
        vt4Averages.put("1", "28");
        vt4Averages.put("2", "57");
        vt4Averages.put("3", "85");
        vt4Averages.put("4", "113");
        vt4Averages.put("5", "142");
        vt4Averages.put("6", "170");
        vt4Averages.put("7", "198");
        vt4Averages.put("8", "226");
        vt4Averages.put("9", "255");

        vt3Averages = FXCollections.observableHashMap();
        vt3Averages.put("1", "28");
        vt3Averages.put("2", "57");
        vt3Averages.put("3", "85");
        vt3Averages.put("4", "113");
        vt3Averages.put("5", "142");
        vt3Averages.put("6", "170");
        vt3Averages.put("7", "198");
        vt3Averages.put("8", "227");
        vt3Averages.put("9", "255");

        vt1Averages = FXCollections.observableHashMap();
        vt1Averages.put("1", "168");
        vt1Averages.put("2", "335");
        vt1Averages.put("3", "503");
        vt1Averages.put("4", "671");
        vt1Averages.put("5", "839");
        vt1Averages.put("6", "1006");
        vt1Averages.put("7", "1174");
        vt1Averages.put("8", "1342");
        vt1Averages.put("9", "1509");

        vt1DipVolume = FXCollections.observableHashMap();
        vt2DipVolume = FXCollections.observableHashMap();
        vt3DipVolume = FXCollections.observableHashMap();
        vt4DipVolume = FXCollections.observableHashMap();


//        extractVt4();
//        extractVt3();

    }

    private void extractVt4() {
        vtDipVolume.clear();
        String sql = "SELECT * FROM virticalTank4";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vtDipVolume.put((rs.getString("dip")),(rs.getString("litres")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void extractVt3() {
        vtDipVolume.clear();
        String sql = "SELECT * FROM virticalTank3";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vtDipVolume.put((rs.getString("dip")),(rs.getString("litres")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void extractVt1() {
        vtDipVolume.clear();
        String sql = "SELECT * FROM virticalTank1";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vtDipVolume.put((rs.getString("dip")),(rs.getString("litres")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void extractVt2() {
        vtDipVolume.clear();
        String sql = "SELECT * FROM virticalTank2";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vtDipVolume.put((rs.getString("dip")),(rs.getString("litres")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void resetValues(){
            vtLitres = 0;
            avgLitres = 0;
    }

    public void onEnterDipBtnClick(ActionEvent actionEvent) {
        String result = enterDip.getText();
        last = result.charAt(result.length() -1);
        getVTDipVolume();
        getVTAverages();

        resetValues();
    }

    public void onCalculateBtnClick(ActionEvent actionEvent) {
        String result = enterDip.getText();
        last = result.charAt(result.length() -1);
        getVTDipVolume();
        getVTAverages();
        resetValues();

    }


        private void getVTDipVolume() {
        if (enterDip.getText().length() == 4){
            for (Map.Entry<String,String> entry : vtDipVolume.entrySet())
                if (entry.getKey().equals(enterDip.getText())){

                    vtLitres = Integer.parseInt(entry.getValue());
                    avgLitres = 1;
                    System.out.println("Key = " +vtLitres);
                }else {
                    if (entry.getKey().substring(0, 3).contains(enterDip.getText().subSequence(0, 3))) {
                        vtLitres = Integer.parseInt(entry.getValue());

                        System.out.println("Key = " + entry.getKey() +
                                ", Value = " + entry.getValue());
                    }
                }
        }else{
            for (Map.Entry<String,String> entry : vtDipVolume.entrySet())
                if (entry.getKey().equals(enterDip.getText())) {

                    vtLitres = Integer.parseInt(entry.getValue());
                    avgLitres = 1;
                    System.out.println("Key = " + vtLitres);
                }else {
                    if (entry.getKey().substring(0, 4).contains(enterDip.getText().subSequence(0, 4))) {
                        if(entry.getKey().length() == 5) {
                            vtLitres = Integer.parseInt(entry.getValue());

                            System.out.println("Key == " + entry.getKey() +
                                    ", Value == " + entry.getValue());
                        }
                    }
                }
        }
    }

    private void getVTAverages() {
        if (avgLitres == 1) {
            avgLitres = 0;
            tfResult.setText(avgLitres + vtLitres + "");
        } else {
            for (Map.Entry<String, String> entry : vtAverages.entrySet())
                if (entry.getKey().equals(last + "")) {
                    avgLitres = Integer.parseInt(entry.getValue());

                    System.out.println("Key = " + entry.getKey() +
                            ", Value = " + entry.getValue());
                }
            tfResult.setText(avgLitres + vtLitres + "");
        }
    }

//    private void getVT4DipVolume() {
//        for (Map.Entry<String,String> entry : vt4DipVolume.entrySet())
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
//
//    private void getVT4Averages() {
//        if (avgLitres == 1) {
//            avgLitres = 0;
//            tfResult.setText(avgLitres + vtLitres + "");
//        } else {
//            for (Map.Entry<String, String> entry : vt4Averages.entrySet())
//                if (entry.getKey().equals(last + "")) {
//                    avgLitres = Integer.parseInt(entry.getValue());
//
//                    System.out.println("Key = " + entry.getKey() +
//                            ", Value = " + entry.getValue());
//                }
//            tfResult.setText(avgLitres + vtLitres + "");
//        }
//    }

    public void cbSelectTankOnAction(ActionEvent actionEvent) {
        String value = cBselectTank.getSelectionModel().getSelectedItem();

        switch (value){
            case "Vertical Tank 1":
                extractVt1();
//                System.out.println(vtDipVolume.size());
                vtAverages = vt1Averages;

                break;
            case "Vertical Tank 2":
                extractVt2();
//                System.out.println(vtDipVolume.size());
                vtAverages = vt2Averages;

                break;
            case "Vertical Tank 3":
                extractVt3();
                vtAverages = vt3Averages;

                break;

            case "Vertical Tank 4":
                extractVt4();
                vtAverages = vt4Averages;
                break;
        }
    }
}