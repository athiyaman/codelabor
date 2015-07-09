# Layered Architecture DTO #

## Class File 생성 ##

  1. Package Explorer에서 Package 선택
  1. Context Menu에서 New > Class 선택
  1. Java Class Dialog 창 표시
  1. Name: 클래스명 입력 (예: xxxDto)
  1. Interface: Serializable 추가
  1. Constructors from superclass 활성화
  1. Generate comments: 활성화

## Field 생성 ##

  1. private으로 field 생성
  1. Type은 가급적이면 primitive type을 지양


## Method 생성 ##

  1. Default Constructor의 TODO 삭제
  1. Generate Constructor using Fields 실행 > Insertion point: First member 선택, Generate constructor comments 활성화
  1. Generate Getters and Setters 실행 > Insertion point: Last member 선택
  1. Generate toString() 실행 > Insertion point: Last member 선택, StringBuilder 활성화, Generate method comments 활성화
  1. Generate hashCode() and equals() 실행 > Insertion point: Last member 선택, Generate method comments 활성화, Use 'instanceof' to compare types 활성화, Use blocks in 'if' statements 활성화
  1. Class명에 표시된 warning 선택 > Add generated serial version ID 실행