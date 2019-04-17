# Playlist Generator Supplementary Specification

# Introduction
In addition to the obvious features and functions that the system provides, there are  requirements that don't actually do anything, but are important characteristics nevertheless. These are called "non-functional requirements" or sometimes "Quality Attributes." A **non-functional requirement** is a requirement that specifies criteria that can be used to judge the operation of a system, rather than specific behaviors. 

The Playlist Generator Supplementary Specification document captures the system requirements, regarding availability, performance, security, testability, usability and also covers the design constraints.

# Non-functional Requirements

Each of the non-functional requirements will be defined in terms of scenarios, respecting and covering the following template: source of stimulus: the entity (human or another system) that generated the stimulus or event, stimulus: a condition that determines a reaction of the system, environment: the current condition of the system when the stimulus arrives, response: the activity determined by the arrival of the stimulus and response measure: the quantifiable indication of the response.

## Availability
The Playlist Generator Application is available to all users who have access to a computer.

 Availability is a performance criterion for repairable systems that accounts for both the reliability and maintainability properties of a component or system. It is defined as the probability that the system is operating properly when it is requested for use. That is, availability is the probability that a system is not failed or undergoing a repair action when it needs to be used.

**Source:**  External to the system

**Stimulus:**  Unanticipated message

**Artifact:**  Process

**Environment:**  Normal operation

**Response:**  Inform operator continue to operate

**Response Measure:**  No downtime



## Performance

The performance characteristics of the system are outlined in this section.

Performance consists in the amount of useful work accomplished by a computer system. Outside of specific contexts, computer performance is estimated in terms of accuracy, efficiency and speed of executing the operations.

One of the most important nonfunctional requirements the customers want is a good and fast performance rate of the PGA system. It exist a responsive sub-goal deals on how fast the system responds to queries, and space sub-goal with storage space. Storage space should not be wasted in order to achieve a good performance.

###  Performance requirements

1. Database Access Response Time: The system shall provide access to the playlist generator database with no more than a 20 second latency.

2. Transaction Response Time: The system must be able to complete 90% of all transactions within 2 minutes.

   **Source:**  Users

   **Stimulus:**  Initiate transactions

   **Artifact:**  System

   **Environment:**  Under normal operations

   **Response:**  Transactions are processed

   **Response Measure:**  Within 2 minutes


## Security

The security non-functional requirement implies that under any unsafe environment or conditions the application should work, and it should not break by sudden attacks from internal or external source.

The security goal is divided into confidentiality,  and integrity. To cover the aspect of confidentiality it is very important to achieve authentication, so the users are required to log into the PGA system by providing a username and a password, it also helps in preventing unauthorized users to log in. Integrity covers completeness such as data validation, accuracy, and consistency. 

**Source:**  Correctly identified individual

**Stimulus:**  Tries to access system services

**Artifact:**  System services

**Environment:**  Under normal operations

**Response:**  Allows access to data and/or services

**Response Measure:**  Restore data/services



## Testability
Testability is the degree to which a software artifact (i.e. a software system, software module, requirements- or design document) supports testing in a given test context. If the testability of the software artifact is high, then finding faults in the system if such faults exist, by means of testing is easier.

The PGAs' functionalities must be able to be tested using JUnit or another methods and needs to be tested.

**Source:**  Unit tester

**Stimulus:**  Performs unit test

**Artifact:**  Component of the system

**Environment:**  At the completion of the component

**Response:**  Component has interface for controlling behavior, and output of the component is observable

**Response Measure:**  Probability of failure if fault exists



## Usability
Usability is the non-functional requirement that refers to the fact that it should be easy for the user to use the application, also easy to learn, operate, prepare inputs and outputs through interaction with a system.

The navigation should be made pleasant and easy and short descriptive titles at the top of each page will be used so the user has a clear understanding of where they are in the application. The presentation of information and the look and feel should be consistent throughout the entire application.

This section lists all of those requirements that relate to, or affect, the usability of the system.

**Source:**  Users

**Stimulus:**  Minimize impact of errors

**Artifact:**  System

**Environment:**  At runtime

**Response:**  Wishes to cancel current operations

**Response Measure:**  Cancellation is performed quickly

1. Windows Compliance: The desktop user-interface shall be Windows 7 compliant.

2. Design for Ease-of-Use: The user interface of the Playlist Generator System shall be designed for ease-of-use and shall be appropriate for a computer-literate user community with no additional training on the System.

# Design Constraints
This section needs to indicate any design constraints on the system being built. Design constraints represent design decisions that have been mandated and must be adhered to. Examples include software languages, software process requirements, prescribed use of developmental tools, architectural and design constraints, purchased components, class libraries, and so on. This section lists any design constraints on the system being built.

1. Software language: The PGA shall be written in Java programming language and the interface will be in English.
2. Database: The data used in the application will be stored in a database (MySQL).
3. All the inputs of the application will be validated against invalid data before submitting the data and saving it.
4. Most of the functionality of the application should be unit tested, so it reaches at least **60%** code coverage. A Mocking framework (e.g., Mockito) will be used to mock dependencies where needed.
5. The users must log in before using the PGA and in the event of introducing wrong data, a log message will appear to notify them.
6. Model-View-Controller pattern in designing the application.

# Resources

* http://www.upedu.org/process/gdlines/md_srs.htm
* Example of Supplementary Specification: http://csis.pace.edu/~marchese/SE616_New/Samples/Example%20%20Supplementary%20Specification.htm
* Supplementary Specification Template: https://www.dau.mil/cop/bes/DAU%20Sponsored%20Documents/Supplementary%20Specification%20Template.doc
* https://en.wikipedia.org/wiki/Non-functional_requirement
* Design Constraint - an overview: https://www.sciencedirect.com/topics/computer-science/design-constraint
