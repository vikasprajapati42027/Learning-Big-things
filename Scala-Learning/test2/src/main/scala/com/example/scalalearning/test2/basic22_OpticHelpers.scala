package com.example.scalalearning.test2

object basic22_OpticHelpers {
  def main(args: Array[String]): Unit = {
    println("=== basic22: Optic helpers ===")
    val user = User(Profile(Address("Main", 1)))
    val composed = profileLens.compose(addressLens).compose(houseLens)
    val updated = composed.set(user, 42)
    println(updated)
  }

  case class Address(street: String, house: Int)
  case class Profile(address: Address)
  case class User(profile: Profile)

  case class Lens[S, A](get: S => A, set: (S, A) => S) {
    def compose[B](other: Lens[A, B]): Lens[S, B] =
      Lens(get andThen other.get, (s, b) => set(s, other.set(get(s), b)))
  }

  val profileLens = Lens[User, Profile](_.profile, (u, profile) => u.copy(profile = profile))
  val addressLens = Lens[Profile, Address](_.address, (profile, address) => profile.copy(address = address))
  val houseLens = Lens[Address, Int](_.house, (address, value) => address.copy(house = value))
}
