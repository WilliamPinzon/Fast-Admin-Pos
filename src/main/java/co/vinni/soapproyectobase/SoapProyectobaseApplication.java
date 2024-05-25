package co.vinni.soapproyectobase;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.extern.log4j.Log4j2;

/**
 * author Vinni 2023
 */
@SpringBootApplication
@Log4j2
public class SoapProyectobaseApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(SoapProyectobaseApplication.class, args);
        System.out.println("proyecto base");
        
//        ConfigurableApplicationContext context = SpringApplication.run(SoapProyectobaseApplication.class, args);
//        System.out.println("proyecto base");
//
//        // Obtenemos la autenticación actual
//        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.getName();
//            System.out.println("Usuario autenticado: " + username);
//        }

    }
}
//    @Autowired
//    RepositorioContribuyente repoEquipo;
//    @Override
//    public void run(String... args) throws Exception {
//
//       List<Contribuyente> listEquip = repoEquipo.findAll();
//       for (Contribuyente contribuyente : listEquip){
//           System.out.println("contri"  +  contribuyente);
//
//       }
//
//    }

