# CloudShop

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

- `build.sh`: Compiles the application and resolves dependencies
- `run.sh`: Starts the CloudShop application

Make sure both scripts have execution permissions:
```
chmod +x build.sh run.sh
```

## License

