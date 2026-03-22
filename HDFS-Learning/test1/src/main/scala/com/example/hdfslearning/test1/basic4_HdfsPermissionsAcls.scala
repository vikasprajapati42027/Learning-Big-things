package com.example.hdfslearning.test1

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.permission.{AclEntry, AclEntryScope, AclEntryType, FsAction}
import org.apache.hadoop.fs.{FileSystem, Path}

object basic4_HdfsPermissionsAcls {
  def main(args: Array[String]): Unit = {
    val conf = new Configuration()
    val fs = FileSystem.get(conf)
    val base = new Path(sys.env.getOrElse("HDFS_DEMO_FS", fs.getDefaultUri(conf).toString) + "/tmp/hdfs_test1/perms")
    fs.mkdirs(base)

    println(s"Default permission on $base: ${fs.getFileStatus(base).getPermission}")

    // Set a restrictive mode and add an ACL entry
    fs.setPermission(base, new org.apache.hadoop.fs.permission.FsPermission("750"))
    val acl = new AclEntry.Builder()
      .setScope(AclEntryScope.ACCESS)
      .setType(AclEntryType.USER)
      .setName("nobody") // replace with real user in your cluster
      .setPermission(FsAction.READ_EXECUTE)
      .build()
    fs.modifyAclEntries(base, java.util.Arrays.asList(acl))

    val status = fs.getFileStatus(base)
    println(s"After chmod 750 and ACL add: perm=${status.getPermission} owner=${status.getOwner} group=${status.getGroup}")
    println("Note: ACL user 'nobody' must exist in the cluster for the entry to matter.")
  }
}
