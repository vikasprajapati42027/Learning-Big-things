import org.springframework.security.access.prepost.PreAuthorize;\npublic class SecureSvc { @PreAuthorize("hasRole('ADMIN')") void delete() {} }
