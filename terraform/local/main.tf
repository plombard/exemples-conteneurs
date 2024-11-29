terraform {
  required_providers {
    local = {
      source = "hashicorp/local"
      version = "2.4.0"
    }
  }
}

provider "local" {
  # Configuration options
}

resource "local_file" "foo" {
  content  = "yolo!"
  filename = "${path.module}/foo.bar"
}

data "local_file" "foo" {
  filename = "${path.module}/foo.bar"
}

output "file_content" {
  value = data.local_file.foo.content
}
