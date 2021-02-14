package com.api.springboot.desafio.services;



import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConversionServiceImpl implements IConversionService
{
	public static final double MINUTE;
	public static final double HOUR;
	public static final double DAY;
	public static final double DEGREE;
	public static final double ARCMINUTE;
	public static final double ARCSEC;
	public static final double HECTARE;
	public static final double LITRE;
	public static final double TONNE;
	

	
	
	public String convertUnits() {
		String unitName;
		double multFactor;
		String unidade;
		
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));

			unitName = (String) jsonObject.get("unit_name");
			multFactor = (double) jsonObject.get("multiplication_factor");
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void pegarUnidade(String unidade) {
		Scanner entrada = new Scanner(System.in);
		unidade = entrada.nextLine();
	}
	
	private boolean validaEntrada(String unidade) {
		if(unidade.isBlank() || !unidade.contains("(") || !unidade.contains(")")) {
			return false;
		}
		return true;
	}
	
	private double converterMinuto() {
		return MINUTE*60;
	}
	
	private double converterHora() {
		return HOUR*3600;
	}
	
	private double converterDia() {
		return DAY*86400;
	}
	
	private double converterGraus() {
		return DEGREE*(3.14/180);
	}
	
	private double converterArcMin() {
		return ARCMINUTE*(3.14/10800);
	}
	
	private double converterArcS() {
		return ARCSEC*(3.14/648000);
	}
	
	private double converterHectare() {
		return HECTARE*1000;
	}
	
	private double converterLitro() {
		return LITRE*0.001;
	}
	
	private double converterTon() {
		return TONNE*1000;
	}

}
