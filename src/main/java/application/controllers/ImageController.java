package application.controllers;

import application.config.Settings;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.nio.file.Paths;

@RestController
@RequestMapping("/image")
public class ImageController {

    @GetMapping(value = "/getByName/{fileName}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<Object> getImage(@PathVariable(value = "fileName") String fileName) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(readImage(fileName));
        }catch (Exception e) {
            if (e.getClass().getSimpleName().endsWith("IOException"))
                return new ResponseEntity<>("errMsg_fileNotFound", HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private byte[] readImage(String fileName) throws Exception {
        String fullPath = Settings.imgStorePath.concat(fileName);
        URL fileURL = Paths.get(fullPath).toUri().toURL();
        //System.out.println(fullPath);
        BufferedImage bImage = ImageIO.read(fileURL);
        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        String extension = fileName.substring(fileName.lastIndexOf("."));
        if (!(".png".equalsIgnoreCase(extension) || ".jpg".equalsIgnoreCase(extension) || ".jpeg".equalsIgnoreCase(extension)))
            throw new Exception("errMsg_invalidFileExtension");
        else
            extension = extension.substring(1);
        ImageIO.write(bImage, extension, baOut);
        return baOut.toByteArray();
    }
}
