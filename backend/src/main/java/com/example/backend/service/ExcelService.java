package com.example.backend.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

    public ByteArrayInputStream gerarRelatorioGastos(List<String> dados) throws IOException {
        String[] colunas = {"Serviço", "Descrição", "Valor", "Data"};
        Map<String, Double> totaisPorServico = new HashMap<>(); // Armazenar totais por serviço
        double totalGeral = 0.0; // Total geral

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Gastos");

            // Cabeçalho
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < colunas.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(colunas[i]);
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            // Dados
            int rowIdx = 1;
            for (String dado : dados) {
                String[] partes = dado.split(";"); // "Banho;Descrição;40.00;2023-12-01"
                String servico = partes[0];
                String descricao = partes[1];
                double valor = Double.parseDouble(partes[2]);
                String data = partes[3];

                // Adicionar os dados na planilha
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(servico);
                row.createCell(1).setCellValue(descricao);
                row.createCell(2).setCellValue(valor);
                row.createCell(3).setCellValue(data);

                // Atualizar totais
                totaisPorServico.put(servico, totaisPorServico.getOrDefault(servico, 0.0) + valor);
                totalGeral += valor;
            }

            // Adicionar totais por serviço no final
            Row rowTotais = sheet.createRow(rowIdx++);
            Cell totalLabelCell = rowTotais.createCell(0);
            totalLabelCell.setCellValue("Totais por Serviço:");
            CellStyle boldStyle = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);
            boldStyle.setFont(boldFont);
            totalLabelCell.setCellStyle(boldStyle);

            for (Map.Entry<String, Double> entry : totaisPorServico.entrySet()) {
                Row totalRow = sheet.createRow(rowIdx++);
                totalRow.createCell(0).setCellValue(entry.getKey());
                totalRow.createCell(2).setCellValue(entry.getValue());
            }

            // Adicionar total geral no final
            Row totalGeralRow = sheet.createRow(rowIdx++);
            Cell totalGeralLabelCell = totalGeralRow.createCell(0);
            totalGeralLabelCell.setCellValue("Total Geral:");
            totalGeralLabelCell.setCellStyle(boldStyle);
            Cell totalGeralValueCell = totalGeralRow.createCell(2);
            totalGeralValueCell.setCellValue(totalGeral);

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
