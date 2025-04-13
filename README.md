# CloudShop (NTUCSIE CNA HW)

A lightweight online marketplace system with command-line interface.

## Overview

CloudShop is a Java-based application that simulates an online marketplace platform where users can register, create listings, browse items by category, and manage their listings. The system processes commands through a command-line interface and persists data by model layers.

## Features

- User registration
- Product listing creation and management
- Category-based product browsing
- Listing retrieval by ID
- Top category statistics
- Data persistence between sessions

## Getting Started

### Prerequisites

- Java JDK 11 or higher
- Maven (for dependency management)

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/gary920209/cloudshop.git
   cd cloudshop
   ```

2. Build the project:
   ```
   ./build.sh
   ```

3. Run the application:
   ```
   ./run.sh
   ```

## Usage

CloudShop accepts the following commands:

- `REGISTER <user_id>` - Register a new user
- `CREATE_LISTING <user_id> '<title>' '<description>' <price> '<category>'` - Create a new listing
- `GET_LISTING <user_id> <listing_id>` - Get details for a specific listing
- `GET_CATEGORY <user_id> '<category>'` - Get all listings in a specific category
- `GET_TOP_CATEGORY <user_id>` - Get the most popular category
- `DELETE_LISTING <user_id> <listing_id>` - Delete a listing

### Example Commands

```
REGISTER user1
CREATE_LISTING user1 'Phone model 8' 'Black color, brand new' 1000 'Electronics'
GET_LISTING user1 100001
GET_CATEGORY user1 'Electronics'
GET_TOP_CATEGORY user1
DELETE_LISTING user1 100001
```

### Batch Processing

You can pass commands from a file:
```
./run.sh < commands.txt
```

## Architecture

CloudShop follows a layered architecture:

- **Models Layer**: Core domain entities
- **Repository Layer**: Data access and persistence
- **Service Layer**: Business logic implementation
- **Command Handler Layer**: Command processing and user interaction

## Database

The application uses H2 Database for data persistence. Database files are automatically created in the project directory when the application runs for the first time.

## Scripts

- `build.sh`: Compiles the application and resolves dependencies, and then tarts the CloudShop application.

Make sure script have execution permissions:
```
chmod +x build.sh 
```
## TODO(for HW2)
- [x] 創建GitHub Repo
- [x] 更改README.md
- [x] 創建Issue
- [x] 有Issue Template
- [x] 創建branch hw1-p
- [x] 創建branch hw1-f
- [x] 以 hw-p 此 branch 對 main 創立 Pull Request
- [x] 以 hw-f 此 branch 對 main 創建 Pull Reques
- [x] 上述任何一個 PR 內有留言互動，針對程式碼變動留言
- [x] 點選 GitHub Action 內有任何 Action 運行過痕跡
- [x] Action 內扣除預設，至少要有額外兩個步驟(Steps)
- [x] hw-p 的 PR 必須要有 GitHub Action 運行，要成功
- [x] hw-f 的 PR 必須要有 GitHub Action 運行，要失敗
## License

