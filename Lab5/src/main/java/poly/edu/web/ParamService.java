package poly.edu.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    /**
     * Đọc chuỗi giá trị của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    /**
     * Đọc số nguyên giá trị của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */
    public int getInt(String name, int defaultValue) {
        String value = request.getParameter(name);
        return value != null ? Integer.parseInt(value) : defaultValue;
    }

    /**
     * Đọc số thực giá trị của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */
    public double getDouble(String name, double defaultValue) {
        String value = request.getParameter(name);
        return value != null ? Double.parseDouble(value) : defaultValue;
    }

    /**
     * Đọc giá trị boolean của tham số
     *
     * @param name         tên tham số
     * @param defaultValue giá trị mặc định
     * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
     */
    public boolean getBoolean(String name, boolean defaultValue) {
        String value = request.getParameter(name);
        return value != null ? Boolean.parseBoolean(value) : defaultValue;
    }

    /**
     * Đọc giá trị thời gian của tham số
     *
     * @param name    tên tham số
     * @param pattern là định dạng thời gian
     * @return giá trị tham số hoặc null nếu không tồn tại
     * @throws RuntimeException lỗi sai định dạng
     */
    public Date getDate(String name, String pattern) {
        String value = request.getParameter(name);
        try {
            if (value != null) {
                return new java.text.SimpleDateFormat(pattern).parse(value);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lưu file upload vào thư mục
     *
     * @param file chứa file upload từ client
     * @param path đường dẫn tính từ webroot
     * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
     * @throws RuntimeException lỗi lưu file
     */
    public File save(MultipartFile file, String path) {
        if (file.isEmpty()) {
            return null;
        }
        try {
            File dir = new File(request.getServletContext().getRealPath(path));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File saveFile = new File(dir, file.getOriginalFilename());
            file.transferTo(saveFile);
            return saveFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
