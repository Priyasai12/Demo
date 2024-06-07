package com.example.imag.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.imag.model.Image;
import com.example.imag.reposistory.UploadRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UploadRepository uploadRepository;

    @GetMapping("/")
    public String index(Model m) {
        List<Image> list = uploadRepository.findAll();
        m.addAttribute("list", list);
        return "index";
    }

    @PostMapping("/imageUpload")
    public String imageUpload(@RequestParam("img") MultipartFile img, HttpSession session) {
        Image im = new Image();
        im.setEmail(img.getOriginalFilename());
        im.setImageName(img.getOriginalFilename()); 
        Image uploadImg = uploadRepository.save(im);

        if (uploadImg != null) {
            try {
                File saveFile = new ClassPathResource("static/img").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                System.out.println(path);
                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        session.setAttribute("msg", "Image Upload Successfully");
        return "redirect:/";
    }
}