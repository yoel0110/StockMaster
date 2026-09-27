# StockMaster — System Requirements

**Name:** StockMaster  
**Type:** Inventory Management System (CRUD)  
**Technology:** Java SE (Pure Java)  
**Interface:** Console (CLI)  
**Storage:** RAM (in-memory), without a database.

---

## 1. Functional Requirements (FR)

### FR-01. Register Products
The system shall allow users to register products with the following attributes:

- Automatically generated unique ID.
- Product name.
- Selling price.
- Available inventory quantity.

**Rules:**
- The product name must not be empty.
- The price must be greater than or equal to zero.
- The quantity must be a non-negative integer.
- The ID must be unique.

### FR-02. List Products
The system shall allow users to view all registered products.

The displayed information shall include the product ID, name, price, and available quantity.

If no products exist, the system shall notify the user.

### FR-03. Search Products
The system shall allow users to search for a product by its ID.

If the product exists, the system shall display its information. Otherwise, it shall notify the user that the product was not found.

### FR-04. Update Products
The system shall allow users to modify the information of an existing product.

Users shall be able to update:

- Name.
- Price.
- Available quantity.

The product ID shall not be modifiable.

### FR-05. Delete Products
The system shall allow users to delete a product by its ID.

Before deleting the product, the system shall request confirmation from the user.

### FR-06. Manage the Main Menu
The system shall display a menu of options that allows users to access CRUD operations and exit the application.

### FR-07. Validate User Input
The system shall validate user input and reject invalid data while displaying descriptive error messages.

### FR-08. Handle Errors
The system shall handle situations such as:

- Searching for non-existent products.
- Selecting invalid menu options.
- Entering data in an incorrect format.
- Attempting to update or delete non-existent products.

### FR-09. Generate Product IDs
The system shall automatically generate a unique identifier for each product registered during the application's execution.

### FR-10. View Inventory Summary
The system shall allow users to view an inventory summary that includes:

- Total number of registered products.
- Total number of available units.
- Total inventory value, calculated as the sum of each product's price multiplied by its quantity.

---

## 2. Non-Functional Requirements (NFR)

| ID | Requirement |
|---|---|
| NFR-01 | **Programming Language:** The system shall be developed using Java SE, without external frameworks. |
| NFR-02 | **Storage:** Data shall be stored in RAM using Java collections. |
| NFR-03 | **Persistence:** Data shall not be required to persist after the application is closed. |
| NFR-04 | **Precision:** Prices shall be represented using `BigDecimal` to avoid binary floating-point precision errors in monetary calculations. |
| NFR-05 | **Performance:** Product lookup by ID shall be performed efficiently using an appropriate data structure, such as `HashMap`. |
| NFR-06 | **Maintainability:** The code shall be organized into classes with separate responsibilities, such as model, service, and console interface. |
| NFR-07 | **Usability:** The menu shall be clear, readable, and easy to use. |
| NFR-08 | **Robustness:** Invalid user input shall not cause the application to terminate unexpectedly. |
| NFR-09 | **Portability:** The system shall run on any operating system compatible with the Java version used. |
| NFR-10 | **Data Integrity:** Update and delete operations shall maintain data consistency in memory. |
| NFR-11 | **Validation:** Data shall be validated before being added to or modified in the product collection. |
| NFR-12 | **Documentation:** The main classes and methods shall include sufficient documentation to facilitate understanding and maintenance. |

---

## 3. Project Constraints

1. The system shall not use relational or NoSQL databases.
2. The system shall not have a graphical user interface; it shall operate exclusively through the console.
3. The system shall not include authentication or user management.
4. The system shall not store data permanently.
5. The system shall not include invoicing, supplier purchasing, or sales management features.

---

## 4. General Acceptance Criteria

The system shall be considered functional when:

- Users can register, list, search, update, and delete products.
- Invalid data is rejected.
- Duplicate identifiers are prevented.
- Monetary values are calculated correctly using `BigDecimal`.
- Users can view the inventory summary.
- The application continues running after invalid input and allows users to exit through a menu option.

