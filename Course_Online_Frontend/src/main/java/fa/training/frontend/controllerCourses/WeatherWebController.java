package fa.training.frontend.controllerCourses;

import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@Controller
public class WeatherWebController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${courses.api.url}")
    private String apiUrl;
    @GetMapping("/home")
    public String index(Model model) {
        String url = apiUrl;
        List<Course> courses = List.of(restTemplate.getForObject(url, Course[].class));
        model.addAttribute("courses", courses);
        return "home-page";
    }
    @GetMapping("/")
    public String index() {
//        model.addAttribute("courses", new Course());
//        System.err.println(model);
        return "home-page";
    }
//    @PostMapping("/")
//    public String getWeatherInfo(@ModelAttribute("weather") WeatherInfo weather, Model model) {
//        String url = apiUrl + "?city=" + weather.getName();
//        WeatherInfo weatherInfo = restTemplate.getForObject(url, WeatherInfo.class);
//        model.addAttribute("weather", weatherInfo);
//        return "weather";
//    }
}
