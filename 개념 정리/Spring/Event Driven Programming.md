# Event Driven Programming

## Event가 뭘까?

event는 말그대로 발생하는 일 그자체를 말하며, 메서드의 실행도 이벤트가 될 수 있고,
어떤 객체의 생성이라던지 등등 프로그램이 작동하면서 발생하는 여러가지 일을 말한다.

### Event로 뭘하는데?

어떤 한 event가 발생했을때, 해당 event가 작동되었다는 걸 확인하고 특정 로직을 수행하게 하는 것이다.

## Spring에서

스프링에서는 Application Event로 이벤트 프로그래밍을 구현할 수 있다.

보통 Spring에서 클래스 본인외의 다른 클래스들의 메서드를 사용하기 위해 DI를 사용한다.

하지만 Application Event를 이용하면 외부 메서드들을 DI 받지않고 사용 할 수 있다.

### 예제

```java
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Feed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT", nullable = false)
    private Long id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    private String title;

    @NotNull
    @Column(columnDefinition = "VARCHAR(1000)")
    private String content;

    @Builder
    public Feed(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
```

```java
@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void execute(CreateFeedRequest request) {
        Feed feed = Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        feedRepository.save(feed);
        eventPublisher.publishEvent(feed);
    }
}
```

feed객체와 feed를 생성해주는 service이다.

위의 CreateFeedService를 보면 
`eventPublisher.publishEvent(feed);` 부분이 이벤트를 발생 시키는 부분이다.

이벤트가 일어나면 새로 생성한 feed 객체를 넘긴다.

```java
@Component
public class FeedEventListener {

    @EventListener
    public void onCreateFeedEvent(Feed feed) {
        System.out.println(feed.getTitle() + " : " + feed.getContent());
    }
}
```

위의 이벤트가 발생했을때 그 이벤트를 수신하는 부분이다.

이벤트는 매개변수로 넘어오는 객체로 구분하고, `@EventListener` 어노테이션을 달게되므로써 이벤트를 구독하는 메서드로 만들어준다. 

이 코드들을 정리해보자면, CreateFeedService의 메서드를 실행하고 메서드가 잘 실행된다면 이벤트를 발행하고, 해당 이벤트를 구독하는 FeedEventListener의 onCreateFeedEvent() 메서드를 실행하게 된다.

이런식으로 Event Driven을 구현할 수 있다.

지금은 간단하게 이벤트 구독자가 제목과 글을 출력하게만 만들었다.
실제로는 event driven을 이용해서 각 기능들의 관심사 이외의 다른 것들을 이벤트 구독자로 처리해서,
여러 도메인간의 강한 결합을 느슨하게 할 수 있다.

## 참고

[https://techblog.woowahan.com/7835/](https://techblog.woowahan.com/7835/)

[https://sabarada.tistory.com/184](https://sabarada.tistory.com/184)