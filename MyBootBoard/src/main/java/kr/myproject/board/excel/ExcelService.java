package kr.myproject.board.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import kr.myproject.board.entity.Board;

@Service
public class ExcelService {
	

    public void download(HttpServletResponse response,List<Board> boardList ) throws IOException {
    	Workbook wb = new XSSFWorkbook();

		org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("첫번째 시트");

		int rowNum = 0;
		Cell cell = null;
		Row row = null;

		String[] headerKey = { "번호", "제목", "등록일", "조회수" };
		row = sheet.createRow(0);
		for (int i = 0; i < headerKey.length; i++) { // 헤더 구성
			cell = row.createCell(i);
			cell.setCellValue(headerKey[i]);
		}

		// Body
		List<Board> boardlist = new ArrayList<Board>();

		for (int i = 0; i < boardlist.size(); i++) {

			row = sheet.createRow(i + 1);
			int cellNum = 0;

			Board board = boardList.get(i);

			cell = row.createCell(cellNum++);
			cell.setCellValue(board.getSeq());
			
			cell = row.createCell(cellNum++);
			cell.setCellValue(board.getTitle());
		
			
			cell = row.createCell(cellNum++);
			cell.setCellValue(board.getCreateDate());
	

		}

		// Download
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=BoardList.xlsx");
		try {
			wb.write(response.getOutputStream());
		} finally {
			wb.close();
		}
	}
}
