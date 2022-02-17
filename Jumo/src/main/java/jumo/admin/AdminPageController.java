package jumo.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import jumo.util.FileUpload;

@Controller
public class AdminPageController {
	
	@RequestMapping(value="/adminMainForm.al")
	public String adminMainForm(Model model) {
		return "adminMainForm";
	}
		
	@RequestMapping(value="/adminMainModify.al")
	public String adminMainModify(MultipartRequest multipartRequest, HttpServletRequest request, Model model) 
			throws IOException { 
		MultipartFile bg_imageFile1 = multipartRequest.getFile("file1");
		MultipartFile bg_imageFile2 = multipartRequest.getFile("file2");
		MultipartFile bg_imageFile3 = multipartRequest.getFile("file3");
		MultipartFile bg_imageFile4 = multipartRequest.getFile("file4");
		MultipartFile bg_imageFile5 = multipartRequest.getFile("file5");
		  
		String saveName1 = "bg_1.jfif";
		String saveName2 = "bg_2.jfif";
		String saveName3 = "bg_3.jfif";
		String saveName4 = "bg_4.jfif";
		String saveName5 = "bg_5.jfif";
		  
		String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "img";
		  
		//String path = request.getSession().getServletContext().getRealPath("/") + File.separator + "img";
		FileUpload.fileUpload(bg_imageFile1, path, saveName1);
		FileUpload.fileUpload(bg_imageFile2, path, saveName2);
		FileUpload.fileUpload(bg_imageFile3, path, saveName3);
		FileUpload.fileUpload(bg_imageFile4, path, saveName4);
		FileUpload.fileUpload(bg_imageFile5, path, saveName5);
		  
		  
		model.addAttribute("msg", "메인 이미지를 등록하였습니다."); 
		model.addAttribute("url", "/main.al");
		  
		return "/admin/adminMainModify"; 
}
	
	/*
	 * 
	 * @RequestMapping(value="/adminMainModify.al") public String
	 * adminMainModify(Model model, MultipartHttpServletRequest request) {
	 * MultipartFile multipartFile = request.getFile("file"); String filename =
	 * multipartFile.getOriginalFilename();
	 * 
	 * 
	 * String savimagename = "bg"+"_"+multipartFile.getOriginalFilename();
	 * FileCopyUtils.copy(multipartFile.getInputStream(), new
	 * FileOutputStream(+"/"+savimagename));
	 * 
	 * String path =
	 * request.getSession().getServletContext().getRealPath("/")+File.separator+
	 * "img";
	 * 
	 * FileUpload.fileUpload(multipartFile, path, savimagename);
	 * 
	 * model.addAttribute("msg", "상품을 등록하였습니다."); model.addAttribute("url",
	 * "/adminMainForm.al");
	 * 
	 * return "/admin/adminMainModify"; }
	 */
	/*
	 * @RequestMapping(value="/adminMainModify.al") public String adminMainModify(
	 * 
	 * @RequestParam("fileName1") String fileName1,
	 * 
	 * @RequestParam("fileName2") String fileName2,
	 * 
	 * @RequestParam("fileName3") String fileName3,
	 * 
	 * @RequestParam("fileName4") String fileName4,
	 * 
	 * @RequestParam("fileUrl1") String fileUrl1,
	 * 
	 * @RequestParam("fileUrl2") String fileUrl2,
	 * 
	 * @RequestParam("fileUrl3") String fileUrl3,
	 * 
	 * @RequestParam("fileUrl4") String fileUrl4, Model model) {
	 * 
	 * model.addAttribute("fileName1", fileName1); model.addAttribute("fileName2",
	 * fileName2); model.addAttribute("fileName3", fileName3);
	 * model.addAttribute("fileName4", fileName4);
	 * 
	 * model.addAttribute("fileUrl1", fileUrl1); model.addAttribute("fileUrl2",
	 * fileUrl2); model.addAttribute("fileUrl3", fileUrl3);
	 * model.addAttribute("fileUrl4", fileUrl4);
	 * 
	 * return "/admin/adminMainModify"; }
	 */
}