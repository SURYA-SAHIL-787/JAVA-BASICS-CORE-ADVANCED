####################################################################################################
#                                                                                                  #
#                            J A V A   M E T H O D S  /  F U N C T I O N S                         #
#                                                                                                  #
####################################################################################################

JAVA METHODS / FUNCTIONS
|
+==================================================================================================+
|  1) CORE IDEA (WHAT A METHOD REALLY IS)                                                          |
+==================================================================================================+
|  |
|  +-- 1.1) DEFINITION
|  |   |
|  |   +-- METHOD = NAMED, REUSABLE BLOCK OF CODE THAT PERFORMS A TASK
|  |   +-- IN JAVA, "FUNCTION" IS GENERALLY A METHOD (JAVA IS CLASS-BASED)
|  |   +-- METHOD CAN: TAKE INPUT (PARAMETERS) + PRODUCE OUTPUT (RETURN)
|  |
|  +-- 1.2) WHY METHODS EXIST (REAL PURPOSE)
|  |   |
|  |   +-- REUSE (DON'T REWRITE CODE)
|  |   +-- MODULARITY (SPLIT PROBLEM)
|  |   +-- READABILITY (CLEAN MAIN)
|  |   +-- MAINTENANCE (CHANGE ONCE)
|  |   +-- TESTING (TEST SMALL UNITS)
|  |
|  +-- 1.3) TERMS (CLEARLY)
|      |
|      +-- PROCEDURE = METHOD RETURNING void
|      +-- FUNCTION  = METHOD RETURNING A VALUE
|      +-- METHOD    = FUNCTION/PROCEDURE THAT BELONGS TO A CLASS/OBJECT
|
+==================================================================================================+
|  2) METHOD ANATOMY (FULL STRUCTURE)                                                              |
+==================================================================================================+
|  |
|  +-- 2.1) COMPLETE TEMPLATE (EVERY PART)
|  |   |
|  |   +-- [ACCESS MODIFIER] [NON-ACCESS MODIFIERS] RETURN_TYPE NAME(PARAMS) THROWS { BODY }
|  |
|  +-- 2.2) ACCESS MODIFIERS (VISIBILITY)
|  |   |
|  |   +-- public
|  |   +-- protected
|  |   +-- (default) PACKAGE-PRIVATE
|  |   +-- private
|  |
|  +-- 2.3) NON-ACCESS MODIFIERS (BEHAVIOR CONTROL)
|  |   |
|  |   +-- static        (CLASS METHOD)
|  |   +-- final         (CANNOT OVERRIDE)
|  |   +-- abstract      (NO BODY)
|  |   +-- synchronized  (THREAD LOCK)
|  |   +-- native        (JNI / C-C++)
|  |   +-- strictfp      (FLOAT RULES)
|  |
|  +-- 2.4) RETURN TYPE (OUTPUT CONTRACT)
|  |   |
|  |   +-- void (NO VALUE)
|  |   +-- PRIMITIVE (int, double, char...)
|  |   +-- OBJECT TYPE (String, Student, int[], List<String> ...)
|  |
|  +-- 2.5) PARAMETERS (INPUT CONTRACT)
|  |   |
|  |   +-- (TYPE name, TYPE name, ...)
|  |   +-- ORDER + COUNT + TYPES MATTER
|  |
|  +-- 2.6) THROWS CLAUSE (ERROR CONTRACT)
|      |
|      +-- throws IOException, ...
|
+==================================================================================================+
|  3) SIGNATURE (THE #1 EXAM TRAP)                                                                 |
+==================================================================================================+
|  |
|  +-- 3.1) WHAT METHOD SIGNATURE MEANS IN JAVA
|  |   |
|  |   +-- METHOD NAME + PARAMETER TYPES (COUNT/ORDER/TYPES)
|  |
|  +-- 3.2) WHAT IS NOT PART OF SIGNATURE
|      |
|      +-- RETURN TYPE IS NOT PART OF SIGNATURE (IMPORTANT)
|      +-- PARAMETER NAMES NOT PART OF SIGNATURE
|
+==================================================================================================+
|  4) TYPES OF METHODS (CLASSIFICATION THAT MAKES LOGIC EASY)                                      |
+==================================================================================================+
|  |
|  +-- 4.1) BY RETURN
|  |   |
|  |   +-- void METHODS
|  |   +-- NON-void METHODS
|  |
|  +-- 4.2) BY PARAMETERS
|      |
|      +-- NO PARAMETERS
|      +-- WITH PARAMETERS
|      +-- VARARGS PARAMETERS
|
+==================================================================================================+
|  5) CALLING METHODS (HOW CONTROL FLOW MOVES)                                                     |
+==================================================================================================+
|  |
|  +-- 5.1) CALL STACK (REAL EXECUTION)
|  |   |
|  |   +-- CALLER PUSHES PARAMETERS
|  |   +-- CONTROL JUMPS INTO METHOD
|  |   +-- LOCAL VARIABLES LIVE INSIDE STACK FRAME
|  |   +-- return SENDS CONTROL BACK + POPS STACK FRAME
|  |
|  +-- 5.2) static CALLS
|  |   |
|  |   +-- ClassName.method()
|  |   +-- SAME CLASS: method()
|  |
|  +-- 5.3) INSTANCE CALLS
|      |
|      +-- objectRef.method()
|      +-- NEED OBJECT (new)
|      +-- this REFERS TO CURRENT OBJECT INSIDE INSTANCE METHOD
|
+==================================================================================================+
|  6) PARAMETERS vs ARGUMENTS (ABSOLUTE CLARITY)                                                   |
+==================================================================================================+
|  |
|  +-- 6.1) DEFINITIONS
|  |   |
|  |   +-- PARAMETERS = VARIABLES IN METHOD DEFINITION
|  |   +-- ARGUMENTS  = ACTUAL VALUES PASSED DURING CALL
|  |
|  +-- 6.2) JAVA PASSING RULE (THE TRUTH)
|  |   |
|  |   +-- JAVA IS ALWAYS PASS-BY-VALUE
|  |   |
|  |   +-- PRIMITIVE PASSED
|  |   |   |
|  |   |   +-- COPY OF VALUE (CALLER VARIABLE DOESN'T CHANGE)
|  |   |
|  |   +-- OBJECT/ARRAY PASSED
|  |       |
|  |       +-- COPY OF REFERENCE
|  |       +-- YOU CAN MUTATE OBJECT/ARRAY CONTENTS
|  |       +-- YOU CANNOT CHANGE CALLER'S REFERENCE TO POINT ELSEWHERE
|
+==================================================================================================+
|  7) RETURN MASTERY (NO-DOUTB ZONE)                                                               |
+==================================================================================================+
|  |
|  +-- 7.1) void METHODS
|  |   |
|  |   +-- return; (OPTIONAL EARLY EXIT)
|  |
|  +-- 7.2) NON-void METHODS
|  |   |
|  |   +-- MUST RETURN VALUE OF DECLARED TYPE
|  |   +-- MUST RETURN ON ALL POSSIBLE PATHS (COMPILER CHECK)
|  |
|  +-- 7.3) MULTIPLE RETURNS
|      |
|      +-- ALLOWED (OFTEN CLEANER)
|      +-- DO NOT MAKE SPAGHETTI LOGIC
|
+==================================================================================================+
|  8) OVERLOADING (COMPILE-TIME POLYMORPHISM)                                                      |
+==================================================================================================+
|  |
|  +-- 8.1) DEFINITION
|  |   |
|  |   +-- SAME METHOD NAME, DIFFERENT PARAMETER LIST
|  |
|  +-- 8.2) VALID WAYS TO OVERLOAD
|  |   |
|  |   +-- DIFFERENT NUMBER OF PARAMETERS
|  |   +-- DIFFERENT TYPES
|  |   +-- DIFFERENT ORDER OF TYPES
|  |
|  +-- 8.3) NOT OVERLOADING (COMMON TRAP)
|      |
|      +-- ONLY CHANGING RETURN TYPE IS NOT ALLOWED
|
+==================================================================================================+
|  9) OVERRIDING (RUNTIME POLYMORPHISM)                                                            |
+==================================================================================================+
|  |
|  +-- 9.1) DEFINITION
|  |   |
|  |   +-- CHILD CLASS PROVIDES NEW IMPLEMENTATION OF PARENT METHOD
|  |
|  +-- 9.2) CORE RULES
|  |   |
|  |   +-- SAME NAME + SAME PARAMETERS (SIGNATURE)
|  |   +-- RETURN TYPE SAME OR COVARIANT
|  |   +-- ACCESS MODIFIER CANNOT BECOME MORE RESTRICTIVE
|  |   +-- @Override RECOMMENDED
|  |
|  +-- 9.3) SPECIAL CASES (TOP INTERVIEW)
|      |
|      +-- static METHODS ARE NOT OVERRIDDEN (THEY ARE HIDDEN)
|      +-- final METHODS CANNOT BE OVERRIDDEN
|      +-- private METHODS ARE NOT OVERRIDDEN (NOT VISIBLE TO CHILD)
|
+==================================================================================================+
| 10) static vs INSTANCE (THE BIG DIVIDE)                                                          |
+==================================================================================================+
|  |
|  +-- 10.1) static METHODS
|  |   |
|  |   +-- BELONG TO CLASS (NO OBJECT REQUIRED)
|  |   +-- NO this
|  |   +-- CAN DIRECTLY ACCESS ONLY static MEMBERS
|  |   +-- USED FOR UTILITIES (Math, Arrays, Helper)
|  |
|  +-- 10.2) INSTANCE METHODS
|      |
|      +-- BELONG TO OBJECT
|      +-- REQUIRE objectRef.method()
|      +-- CAN ACCESS INSTANCE + static MEMBERS
|
+==================================================================================================+
| 11) CONSTRUCTORS (METHOD-LIKE BUT NOT A METHOD)                                                  |
+==================================================================================================+
|  |
|  +-- 11.1) CORE RULES
|  |   |
|  |   +-- NAME SAME AS CLASS
|  |   +-- NO RETURN TYPE (NOT EVEN void)
|  |   +-- RUNS ON new
|  |
|  +-- 11.2) TYPES
|  |   |
|  |   +-- DEFAULT (PROVIDED IF NONE WRITTEN)
|  |   +-- NO-ARG
|  |   +-- PARAMETERIZED
|  |
|  +-- 11.3) CONSTRUCTOR OVERLOADING
|  |
|  +-- 11.4) this() / super()
|      |
|      +-- this()  CALL SAME CLASS CONSTRUCTOR (FIRST LINE)
|      +-- super() CALL PARENT CONSTRUCTOR (FIRST LINE)
|
+==================================================================================================+
| 12) VARARGS (FLEXIBLE PARAMETERS)                                                                |
+==================================================================================================+
|  |
|  +-- 12.1) SYNTAX
|  |   |
|  |   +-- method(TYPE... args)
|  |
|  +-- 12.2) RULES
|      |
|      +-- VARARGS MUST BE LAST PARAMETER
|      +-- INSIDE METHOD: args IS AN ARRAY
|
+==================================================================================================+
| 13) RECURSION (METHOD CALLS ITSELF)                                                              |
+==================================================================================================+
|  |
|  +-- 13.1) CORE PARTS
|  |   |
|  |   +-- BASE CASE (STOP)
|  |   +-- RECURSIVE CASE (CALL AGAIN)
|  |
|  +-- 13.2) REAL RISKS
|      |
|      +-- STACK OVERFLOW IF NO BASE CASE / TOO DEEP
|      +-- PERFORMANCE IF RE-COMPUTING (NEEDS DP/MEMO IDEA)
|
+==================================================================================================+
| 14) EXCEPTIONS + METHODS (ERROR CONTRACT + CONTROL)                                              |
+==================================================================================================+
|  |
|  +-- 14.1) throws (DECLARE)
|  |
|  +-- 14.2) try/catch INSIDE METHOD
|  |
|  +-- 14.3) CHECKED vs UNCHECKED (AWARENESS)
|
+==================================================================================================+
| 15) METHOD DESIGN (TOP 0.1% CODING DISCIPLINE)                                                   |
+==================================================================================================+
|  |
|  +-- 15.1) SINGLE RESPONSIBILITY (ONE JOB ONLY)
|  |
|  +-- 15.2) PURE vs IMPURE METHODS (PRO MINDSET)
|  |   |
|  |   +-- PURE: NO SIDE EFFECTS, SAME INPUT -> SAME OUTPUT
|  |   +-- IMPURE: PRINT/IO/MUTATE GLOBAL STATE
|  |
|  +-- 15.3) PARAMETER QUALITY
|  |   |
|  |   +-- MINIMAL PARAMETERS
|  |   +-- AVOID MANY PRIMITIVE FLAGS (BETTER DESIGN IDEA)
|  |
|  +-- 15.4) RETURN QUALITY
|  |   |
|  |   +-- RETURN VALUES INSTEAD OF PRINTING (TESTABLE)
|  |   +-- USE CLEAR ERROR STRATEGY (EXCEPTION / OPTIONAL IDEA)
|  |
|  +-- 15.5) NAMING + READABILITY
|      |
|      +-- VERB-BASED NAMES (calculateTotal, isValid, buildReport)
|      +-- CONSISTENT STYLE + SMALL METHODS
|
+==================================================================================================+
| 16) FINAL TOP 0.1% CHECKLIST (IF YOU KNOW THESE, YOU MASTER METHODS)                             |
+==================================================================================================+
   |
   +-- METHOD STRUCTURE (MODIFIERS + RETURN + NAME + PARAMS + BODY + THROWS)
   +-- SIGNATURE RULE (RETURN TYPE NOT INCLUDED)
   +-- PARAMETER vs ARGUMENT
   +-- PASS-BY-VALUE TRUTH (PRIMITIVE vs OBJECT/ARRAY)
   +-- RETURN RULES (void vs non-void, ALL PATHS RETURN)
   +-- static vs INSTANCE (this, OBJECT REQUIRED OR NOT)
   +-- OVERLOADING vs OVERRIDING (RULES + TRAPS)
   +-- CONSTRUCTOR RULES (NO RETURN TYPE, this()/super())
   +-- VARARGS RULES (LAST PARAMETER, IS ARRAY)
   +-- RECURSION (BASE CASE, STACK)
   +-- EXCEPTIONS (throws vs try/catch)

####################################################################################################
