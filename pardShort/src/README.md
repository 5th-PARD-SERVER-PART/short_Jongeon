# Post API 명세서

---

## 1. 포스트 생성

* **URL**: `/post`
* **Method**: `POST`
* **Request Body**:

```json
{
  "question": "오늘 무엇을 배웠나요",
  "tag": "논리설계",
  "content": "재밌는거"
}
```

* **Response**: `200 OK` 또는 `201 Created`

---

## 2. 태그로 포스트 조회

* **URL**: `/post/{tag}`
* **Method**: `GET`
* **Response**:

```json
[
  {
    "tag": "논리설계",
    "content": "ㅇ",
    "question": "수업 내용을 내가 직접 설명한다면 어떻게 말할까?"
  },
  {
    "tag": "논리설계",
    "content": "사랑해요 이 한마디",
    "question": "수업 내용을 내가 직접 설명한다면 어떻게 말할까?"
  }
]
```

---

