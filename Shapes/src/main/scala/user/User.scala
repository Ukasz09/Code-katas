package main.scala.user

import main.scala.Logger

//primary constructor
class User(var name: String, var surname: String) {
  addName(name)
  addSurname(name)

  var email: Option[String] = None
  var phoneNo: Option[String] = None

  //auxiliary constructor
  def this(name: String, surname: String, email: String, phoneNo: String) {
    this(name, surname)
    addEmail(email)
    addPhoneNo(phoneNo)
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private def addEmail(email: String): Unit = {
    if (isValidEmail(email))
      this.email = Some(email)
    else Logger.errorLog("Incorrect email=" + email + ".Set to default")
  }

  private def isValidEmail(email: String): Boolean = {
    val regex: String = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    email.matches(regex)
  }

  private def addPhoneNo(phoneNo: String): Unit = {
    if (isValidPhoneNo(phoneNo))
      this.phoneNo = Some(phoneNo)
    else Logger.errorLog("Invalid phone number=" + phoneNo + ". Set to default")
  }

  private def isValidPhoneNo(phone: String): Boolean = {
    val regex: String = "\\(?\\+[0-9]{1,3}\\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}( ?-?[0-9]{3})? ?(\\w{1,10}\\s?\\d{1,6})?"
    return phone.matches(regex)
  }

  private def addName(name: String): Unit = {
    if (!name.isEmpty)
      this.name = name;
    else {
      this.name = User.DEFAULT_NAME
      Logger.errorLog("Incorrect arg: name=" + name + ".Set to default=" + User.DEFAULT_NAME)
    }
  }

  private def addSurname(surname: String): Unit = {
    if (!surname.isEmpty)
      this.surname = surname;
    else {
      this.surname = User.DEFAULT_SURNAME
      Logger.errorLog("Incorrect arg: surname=" + surname + ".Set to default=" + User.DEFAULT_SURNAME)
    }
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  override def equals(other: Any): Boolean = other match {
    case that: User =>
      (that canEqual this) &&
        name == that.name &&
        surname == that.surname
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[User]

  override def hashCode(): Int = {
    val state = Seq(name, surname)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"User(Name: $name, Surname: $surname, Email: $email, Phone: $phoneNo)"

}

object User {
  val DEFAULT_NAME: String = "Unknown"
  val DEFAULT_SURNAME: String = "Unknown"
}


