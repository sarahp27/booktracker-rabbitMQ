package afn.xloop.booktracker_cnsd23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.Scheduled;

@RestController
@RequestMapping("/insertBook")

public class BookController {

    @Autowired
    private BookRepository repository;
    
    @Autowired
    private RabbitTemplate rabbitTemp;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage(){
        String message = "Book Saved!";
        this.rabbitTemp.convertAndSend(queue.getName(), message);
        System.out.println("Sent:'" +message+ "'");
    }

    @PostMapping("/post")
    public void saveBook(@RequestBody Book book)
    {
        sendMessage();
        repository.saveBook(book);
    }
}