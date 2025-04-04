###### 나는 이세상을 컨트롤할 김종언이다
### @Controller
## #인생

# Spring Controller와 REST API

## 1. Controller와 RestController

### `@Controller`
- HTML(뷰 템플릿)을 반환하는 컨트롤러.
- 데이터가 아닌 화면(View)을 응답으로 반환.
- 주로 **Thymeleaf** 같은 템플릿 엔진과 함께 사용됨.

```java
@Controller
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";  // → hello.html 렌더링
    }
}
```

### `@RestController`
- REST API 개발 시 사용되는 컨트롤러.
- **HTML이 아닌 JSON 데이터를 반환**.
- `@Controller`에 `@ResponseBody`가 추가된 형태.

```java
@RestController
public class MyRestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

### `@Controller` + `@ResponseBody`
- `@Controller`에서 `@ResponseBody`를 추가하면 **JSON 반환 가능**.

```java
@Controller
public class MyController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

## 2. Mapping 어노테이션
HTTP 요청을 처리하는 **Mapping 어노테이션**에는 여러 종류가 있음.

### 주요 Mapping 종류

| 어노테이션        | HTTP 메서드 |
|-----------------|------------|
| `@GetMapping`    | GET        |
| `@PostMapping`   | POST       |
| `@PutMapping`    | PUT        |
| `@PatchMapping`  | PATCH      |
| `@DeleteMapping` | DELETE     |

### `@RequestMapping`
- 여러 HTTP 메서드를 처리할 수 있는 **범용적인 어노테이션**.
- `method` 속성을 지정하면 특정 HTTP 메서드만 처리 가능.

```java
@RequestMapping(value = "/users", method = RequestMethod.GET)
public String getUsers() {
    return "User List";
}
```

> 단, 일반적으로는 `@GetMapping`, `@PostMapping` 등을 사용하는 것이 더 직관적이고 유지보수에 유리함.

## 3. 요청 데이터 받기 (`@PathVariable` vs `@RequestParam`)

### `@PathVariable` (URL 경로 변수 받기)
- URL 경로의 일부를 **변수처럼 받아올 때 사용**.

```java
@GetMapping("/users/{id}")
public String getUser(@PathVariable int id) {
    return "User ID: " + id;
}
```

✅ **예제 요청:** `/users/5` → `User ID: 5`

### `@RequestParam` (쿼리 스트링 데이터 받기)
- URL 뒤 `?key=value` 형태의 쿼리 스트링 값을 받을 때 사용.
- 기본값 설정 가능.

```java
@GetMapping("/users")
public String getUserInfo(
    @RequestParam(required = false, defaultValue = "guest") String name
) {
    return "User Name: " + name;
}
```

✅ **예제 요청:** `/users?name=kim` → `User Name: kim`
✅ **예제 요청:** `/users` → `User Name: guest` (기본값 반환)

### `@RequestParam` 속성

| 속성         | 설명 |
|-------------|----------------------------------|
| `required`  | 값이 필수인지 여부 (기본값: `true`) |
| `defaultValue` | 기본값 설정 (문자열 형태로만 가능) |

```java
@GetMapping("/users")
public String getUserInfo(
    @RequestParam(required = false, defaultValue = "3") int age
) {
    return "Age: " + age;
}
```

✅ **예제 요청:** `/users` → `Age: 3` (Spring이 자동 변환하여 반환)

## 4. 정리
✅ `@Controller` → HTML 반환  
✅ `@RestController` → JSON 반환  
✅ `@RequestMapping` → 범용적인 요청 처리  
✅ `@PathVariable` → URL 경로에서 값 받기  
✅ `@RequestParam` → 쿼리 스트링에서 값 받기 (기본값 설정 가능)

이제 Spring에서 컨트롤러와 API 매핑을 쉽게 이해하고 활용할 수 있습니다! 🚀

