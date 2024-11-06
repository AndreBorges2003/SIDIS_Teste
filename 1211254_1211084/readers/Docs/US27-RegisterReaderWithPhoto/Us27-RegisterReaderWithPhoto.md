# Register Reader with optional Photo
## 1. Requirements Engineering
### 1.1. User Story Description

As anonymous I want to register as a reader with an optional photo, and optional list of interest
(i.e., the genre I’m interested in).

### 1.2. Acceptance Criteria
- Same acceptance criteria as WP#3A.11
- The photo is optional
- The list of interest is optional
- The photo must be of format JPEG, JPG or PNG and must not exceed 20KB

### 1.3 Input and Output Data

**Input Data:**
* Typed data:
    * Name
    * Email
    * Date of Birth
    * Phone Number
    * GDPR Consent
    * Username
    * Password
    * Photo (Optional)
    * List of Interests (Optional)

**Output Data:**

* (In)success of the operation

## 2. Design
### 2.1. Process View
#### 2.1.1. Level 1
![SD](US27-N1.svg)
#### 2.1.2. Level 2
![SD](us27-N2.svg)
#### 2.1.3. Level 3
![SD](us27-N3.svg)
